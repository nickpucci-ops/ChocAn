package project4.layouts;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import project4.Employee;
import project4.Manager;
import project4.Member;
import project4.Provider;
import project4.Service;
import project4.Terminal;
import project4.report.MemberReport;


public class ManagerMenu extends Menu implements ActionListener {
	private static final long serialVersionUID = 7059180387276164616L;
	
	//Terminal terminal;
	
	ArrayList<MemberReport> memberReports;
	ArrayList<Member> members;
	
	JPanel mainMenuPanel;
	JButton runMemberReportBtn;
	JButton runProviderReportBtn;
	JButton runManagerReportBtn;
	JButton runEFTBtn;
	JButton runSummaryReportBtn;
	
	JPanel summaryReportPanel;
	JButton summaryReportBackBtn;
	
	JPanel memberReportPanel;
	JButton memberReportBackBtn;
	JLabel memberChoiceLabel;
	JComboBox<String> memberChoiceBox;
	JButton runMemberReportChoiceBtn;
	
	JPanel providerReportPanel;
	JButton providerReportBackBtn;
	JLabel providerChoiceLabel;
	JComboBox<String> providerChoiceBox;
	JButton runProviderReportChoiceBtn;
	
	JPanel EFTPanel;
	JButton EFTBackBtn;
	JLabel EFTChoiceLabel;
	JComboBox<String>EFTChoiceBox;
	JButton runEFTReportChoiceBtn;
	
	public ManagerMenu(Terminal terminal) {
		super(terminal);		
		this.setTitle("Manager");
		
		memberReports = new ArrayList<MemberReport>();
		
		mainMenuPanel = new JPanel(new GridLayout(0, 1));
		runMemberReportBtn = new JButton("Run Member Report");
		runMemberReportBtn.addActionListener(this);
		mainMenuPanel.add(runMemberReportBtn);
		runProviderReportBtn = new JButton("Run Provider Report");
		runProviderReportBtn.addActionListener(this);
		mainMenuPanel.add(runProviderReportBtn);
		runEFTBtn = new JButton("Run EFT");
		runEFTBtn.addActionListener(this);
		mainMenuPanel.add(runEFTBtn);
		runSummaryReportBtn = new JButton("Run Summary Report");
		runSummaryReportBtn.addActionListener(this);
		mainMenuPanel.add(runSummaryReportBtn);
		main.add(mainMenuPanel);
		
		memberReportPanel = new JPanel();
		memberChoiceLabel = new JLabel("Choose member to run report: ");
		memberReportPanel.add(memberChoiceLabel);
		memberChoiceBox = new JComboBox<String>();
		memberReportPanel.add(memberChoiceBox);
		runMemberReportChoiceBtn = new JButton("Enter");
		runMemberReportChoiceBtn.addActionListener(this);
		
		
		providerReportPanel = new JPanel();
		providerChoiceLabel = new JLabel("Choose provider to run report: ");
		providerReportPanel.add(providerChoiceLabel);
		providerChoiceBox = new JComboBox<String>();
		providerReportPanel.add(providerChoiceBox);
		runProviderReportChoiceBtn = new JButton("Enter");
		runProviderReportChoiceBtn.addActionListener(this);
		
		EFTPanel = new JPanel();
		EFTChoiceLabel = new JLabel("Choose provider to run report: ");
		EFTPanel.add(EFTChoiceLabel);
		EFTChoiceBox = new JComboBox<String>();
		EFTPanel.add(EFTChoiceBox);
		runEFTReportChoiceBtn = new JButton("Enter");
		runEFTReportChoiceBtn.addActionListener(this);
		
		summaryReportPanel = new JPanel();
		summaryReportBackBtn = new JButton("Back");
		summaryReportBackBtn.addActionListener(this);
		
		memberReportBackBtn = new JButton("Back");
		memberReportBackBtn.addActionListener(this);
		providerReportBackBtn = new JButton("Back");
		EFTBackBtn = new JButton("Back");
		providerReportBackBtn.addActionListener(this);
		EFTBackBtn.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== runMemberReportBtn) {
			clear();
			main.add(memberReportPanel);
			populateMemberComboBox(memberChoiceBox);
			addFooterButton(runMemberReportChoiceBtn);
			addFooterButton(memberReportBackBtn);
			setTitle("Member Report");
		}
		else if(e.getSource() == runProviderReportBtn) {
			clear();
			main.add(providerReportPanel);
			populateProviderComboBox(providerChoiceBox);
			addFooterButton(runProviderReportChoiceBtn);
			addFooterButton(providerReportBackBtn);
			setTitle("Provider Report");
		}
		else if(e.getSource() == runEFTBtn) {
			clear();
			main.add(EFTPanel);
			populateProviderComboBox(EFTChoiceBox);
			addFooterButton(runEFTReportChoiceBtn);
			addFooterButton(EFTBackBtn);
			setTitle("EFT");
		}
		else if(e.getSource() == runSummaryReportBtn) {
			Manager loggedInManager = (Manager) terminal.getLoggedInEmployee();
			loggedInManager.getSummaryReport(terminal);
		}
		else if(e.getSource() == getLogoutBtn()) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Manager");
		}  
		else if(e.getSource() == runMemberReportChoiceBtn) {
			Member selectedMember = getSelectedMember();
			Manager loggedInManager = (Manager) terminal.getLoggedInEmployee();
			loggedInManager.getMemberReport(terminal, selectedMember);
		}
		else if(e.getSource() == runProviderReportChoiceBtn) {
			Provider selectedProvider = getSelectedProvider();
			Manager loggedInManager = (Manager) terminal.getLoggedInEmployee();
			loggedInManager.getProviderReport(terminal, selectedProvider);
		}
		else if(e.getSource() == runEFTReportChoiceBtn) {
			Provider selectedProvider = getSelectedProvider();
			Manager loggedInManager = (Manager) terminal.getLoggedInEmployee();
			loggedInManager.getProviderReport(terminal, selectedProvider);
		}
		else if(e.getSource() == memberReportBackBtn ||
	            e.getSource() == providerReportBackBtn ||
	            e.getSource() == EFTBackBtn ||
	            e.getSource() == summaryReportBackBtn) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Manager");
		}
		else {
			clear();
			main.add(mainMenuPanel);
			setTitle("Manager");
		}
		main.revalidate();
		main.repaint();
	}
	
	private void populateMemberComboBox(JComboBox<String> comboBox) {
		comboBox.removeAllItems();
		for(Member member : terminal.getMembers()) {
			comboBox.addItem(member.getName());
		}
	}
	
	private void populateProviderComboBox(JComboBox<String> comboBox) {
		comboBox.removeAllItems();
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getEmployeeType() == Employee.PROVIDER) {
				comboBox.addItem(String.valueOf(((Provider)employee).getName()));
			}
		}
	}
	private Member getSelectedMember() {
		String selectedMemberName = (String) memberChoiceBox.getSelectedItem();
		return terminal.getMemberByName(selectedMemberName);
	}
	private Provider getSelectedProvider() {
		String selectedProviderNumber = (String) providerChoiceBox.getSelectedItem();
		return terminal.getProviderByName((String)providerChoiceBox.getSelectedItem());
	}
	/*not needed
	 * private Provider getSelectedProvider() {
		String selectedProviderNumer = (String) providerChoiceBox.getSelectedItem();
		return terminal.getProviderByNumber(selectedProviderNumber);
	}*/ 
	
	/*private ArrayList<Service> getMemberServices(Member member) {
	    ArrayList<Service> memberServices = new ArrayList<>();
	    for (Member member : terminal.getServices()) {
	        if (member.getName().equals(name)) {
	            memberServices.add(service);
	        }
	    }
	    return memberServices;
	}*/
	
	
}
