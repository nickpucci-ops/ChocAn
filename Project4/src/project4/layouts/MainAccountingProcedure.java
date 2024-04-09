package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import project4.*;
import project4.report.MemberReport;
import project4.report.ProviderReport;
import project4.report.SummaryReport;

/**
 * The MainAccountingProcedure class is used to navigate the UI for the
 * main accounting procedure and creating and displaying pdf files for
 * each report
 * @author Davis Moman
 */

public class MainAccountingProcedure extends Panel implements ActionListener {

	private static final long serialVersionUID = -3934833398410949394L;
	
	private static final short MEMBER_REPORTS = 0;
	private static final short PROVIDER_REPORTS = 1;
	private static final short SUMMARY_REPORT = 2;
	
	Terminal terminal;
	JButton continueBtn;
	
	short panelPos;
	
	JPanel memberReportPanel;
	ArrayList<MemberReport> memberReports;
	ArrayList<ProviderReport> providerReports;
	SummaryReport summaryReport;
	
	JPanel providerReportPanel;
	JLabel providerReportLabel1;
	JLabel providerReportLabel2;
	JLabel providerReportLabel3;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	protected JPanel main;
	private JLabel title;
	
	private JButton loginBtn;
	
	/**
	 * Constructor for the MainAccountingProcedure class
	 * 
	 * @param terminal is the base terminal used to enter this class
	 */
	public MainAccountingProcedure(Terminal terminal) {
		super();
		this.terminal = terminal;
		this.setLayout(new BorderLayout());
		
		memberReports = new ArrayList<MemberReport>();
		providerReports = new ArrayList<ProviderReport>();
		
		topPanel = new JPanel();
		main = new JPanel(new GridLayout(0, 2));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		loginBtn = new JButton("Return to Log In");
		loginBtn.addActionListener(terminal);
		loginBtn.addActionListener(this);
		bottomPanel.add(loginBtn);
		
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);
		
		title = new JLabel("Main Accounting Procedure");
		topPanel.add(title);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(main, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		MainAccountingStart();
		
	}
	
	/**
	 * Checks if an action was performed on any buttons in the UI
	 * Open button opens corresponding report file
	 * Continue button changes to next page (member reports -> provider reports -> summary report)
	 * Return to log in button returns UI to the log in page
	 * 
	 * @param e the action that triggered this void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Open")) {
			String type = (String)((JButton)e.getSource()).getClientProperty("type");
			if(type.equals("member")) {
				int index = (int)((JButton)e.getSource()).getClientProperty("index");
				memberReports.get(index).open();
			} else if(type.equals("provider")) {
				int index = (int)((JButton)e.getSource()).getClientProperty("index");
				providerReports.get(index).open();
			}
		} else if(s.equals("Open Summary Report")) {
			summaryReport.open();
		}
		else if(e.getSource() == continueBtn) {
			panelPos++;
			switch(panelPos) {
			case(MEMBER_REPORTS):
				createMemberReports();
				switchToMemberPanel();
				break;
			case(PROVIDER_REPORTS):
				createProviderReports();
				switchToProviderPanel();
				break;
			case(SUMMARY_REPORT):
				createSummaryReport();
				switchToSummaryPanel();
				break;
			default:
				createMemberReports();
				switchToMemberPanel();
				break;
			}
		}			
		main.revalidate();
		main.repaint();
		
	}
	
	/**
	 * Called when the terminal actionListener changes the UI to the MainAccountingProcedure UI
	 */
	public void MainAccountingStart() {
		panelPos = MEMBER_REPORTS;
		createMemberReports();
		switchToMemberPanel();
	}
	
	/**
	 * Creates an ArrayList of memberReports to use for the UI and file opening
	 */
	private void createMemberReports() {
		memberReports.clear();
		ArrayList<Service> sampleServices = new ArrayList<Service>();
		Provider sampleProvider = new Provider(1, "Username", "Jeremy Smith", 2, "Street St", "Tuscaloosa", "AL", 12345);
		Date today = new Date();
		Service sampleService = new Service("Service Name", 123456, (float)12.34, today, today, terminal.getMembers().get(0), sampleProvider, "Comments");
		sampleServices.add(sampleService);
		sampleServices.add(sampleService);
		for(Member member : terminal.getMembers()) {
			MemberReport newReport = new MemberReport(member, "Member_Report-" + member.getMemberNumber() + ".pdf", sampleServices);
			memberReports.add(newReport);//terminal.getServicesForMember(member)
		}
	}
	
	
	/**
	 * Changes the UI to display all memberReports and buttons to open their corresponding PDF files
	 */
	private void switchToMemberPanel() {
		main.removeAll();
		title.setText("Member Reports");
		for(Member member : terminal.getMembers()) {
			main.add(new JLabel(member.getName()));
			JButton newBtn = new JButton("Open");
			newBtn.setSize(300, 100);
			newBtn.putClientProperty("type", "member");
			newBtn.putClientProperty("index", terminal.getMembers().indexOf(member));
			newBtn.addActionListener(this);
			main.add(newBtn);
		}
		bottomPanel.add(continueBtn);
	}
	
	
	/**
	 * Creates an ArrayList of providerReports to use for the UI and file opening
	 */
	private void createProviderReports() {
		Provider provider;
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getEmployeeType() == Employee.PROVIDER) {
				provider = (Provider)employee;
				ProviderReport newReport = new ProviderReport(provider, "Provider_Report-" + provider.getId() + ".pdf", terminal.getServicesForProvider(provider));
				providerReports.add(newReport);
			}
		}
	}
	
	/**
	 * Changes the UI to display all providerReports and buttons to open their corresponding PDF files
	 */
	private void switchToProviderPanel() {
		main.removeAll();
		title.setText("Provider Reports");
		int provCount = 0;
		this.createProviderReports();
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getEmployeeType() == Employee.PROVIDER) {
				main.add(new JLabel(employee.getUsername()));
				JButton newBtn = new JButton("Open");
				newBtn.setSize(300, 100);
				newBtn.putClientProperty("type", "provider");
				newBtn.putClientProperty("index", provCount);
				newBtn.addActionListener(this);
				main.add(newBtn);
				provCount++;
			}
		}
	}

	/**
	 * Creates a pdf file for the summaryReport
	 */
	private void createSummaryReport() {
		summaryReport = new SummaryReport(terminal, "summary.pdf");
	}
	
	/**
	 * Changes the UI to display the summaryReport and a button to open the corresponding PDF file
	 */
	private void switchToSummaryPanel() {
		main.removeAll();
		title.setText("Summary Report");
		JButton openReport = new JButton("Open Summary Report");
		openReport.addActionListener(this);
		main.add(openReport);
		bottomPanel.remove(continueBtn);
		main.revalidate();
		main.repaint();
		bottomPanel.revalidate();
		bottomPanel.repaint();
	}
}

/*	List of sample services for testing purposes
	--------------------------------------------
		ArrayList<Service> sampleServices = new ArrayList<Service>();
		Provider sampleProvider = new Provider(1, "Username", "Jeremy Smith", 2, "Street St", "Tuscaloosa", "AL", 12345);
		Date today = new Date();
		Service sampleService = new Service("Service Name", 123456, (float)12.34, today, today, terminal.getMembers().get(0), sampleProvider, "Comments");
		sampleServices.add(sampleService);
		sampleServices.add(sampleService);
*/