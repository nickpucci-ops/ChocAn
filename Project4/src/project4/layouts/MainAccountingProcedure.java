package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import project4.*;
import project4.report.MemberReport;

public class MainAccountingProcedure extends Panel implements ActionListener {

	private static final long serialVersionUID = -3934833398410949394L;
	
	Terminal terminal;
	JButton continueBtn;
	
	int memberPanelPos;
	String[] memberNames = {"John", "Joe", "Mary"};
	
	JPanel memberReportPanel;
	ArrayList<MemberReport> memberReports;
	
	JPanel providerReportPanel;
	JLabel providerReportLabel1;
	JLabel providerReportLabel2;
	JLabel providerReportLabel3;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	protected JPanel main;
	private JLabel title;
	
	private JButton loginBtn;
	
	public MainAccountingProcedure(Terminal terminal) {
		super();
		this.terminal = terminal;
		this.setLayout(new BorderLayout());
		
		memberReports = new ArrayList<MemberReport>();
		
		topPanel = new JPanel();
		main = new JPanel(new GridLayout(0, 2));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		loginBtn = new JButton("Log out");
		loginBtn.addActionListener(terminal);
		loginBtn.addActionListener(this);
		bottomPanel.add(loginBtn);
		
		continueBtn = new JButton("Continue");
		continueBtn.addActionListener(this);
		bottomPanel.add(continueBtn);
		
		
		
		title = new JLabel("Main Accounting Procedure");
		topPanel.add(title);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(main, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		MainAccountingStart();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Open")) {
			String type = (String)((JButton)e.getSource()).getClientProperty("type");
			if(type.equals("member")) {
				int index = (int)((JButton)e.getSource()).getClientProperty("index");
				memberReports.get(index).open();
			}
		} else if(e.getSource() == continueBtn) {
			
		}
		
		main.revalidate();
		main.repaint();
		
	}
	
	public void MainAccountingStart() {
		createMemberReports();
		switchToMemberPanel();
	}
	
	private void createMemberReports() {
		memberReports.clear();
		for(Member member : terminal.getMembers()) {
			MemberReport newReport = new MemberReport(member, "Member_Report-" + member.getMemberNumber() + ".pdf");
			memberReports.add(newReport);
		}
	}
	
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
	}
	
	private void createProviderReports() {
		
	}
	
	private void switchToProviderPanel() {
		main.removeAll();
		title.setText("Provider Reports");
	}


}
