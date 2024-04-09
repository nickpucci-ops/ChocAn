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
	
	JPanel managerReportPanel;
	JButton managerReportBackBtn;
	
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
		runManagerReportBtn = new JButton("Run Manager Report");
		runManagerReportBtn.addActionListener(this);
		mainMenuPanel.add(runManagerReportBtn);
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
		
		managerReportPanel = new JPanel();
		managerReportBackBtn = new JButton("Back");
		managerReportBackBtn.addActionListener(this);
		
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
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== runMemberReportBtn) {
			clear();
			main.add(memberReportPanel);
			populateMemberComboBox(memberChoiceBox);
			addFooterButton(runMemberReportChoiceBtn);
			setTitle("Member Report");
		}
		else if(e.getSource() == runProviderReportBtn) {
			clear();
			main.add(providerReportPanel);
			populateProviderComboBox(providerChoiceBox);
			addFooterButton(runProviderReportChoiceBtn);
			setTitle("Provider Report");
		}
		else if(e.getSource() == runManagerReportBtn) {
			clear();
			main.add(managerReportPanel);
			addFooterButton(managerReportBackBtn);
			setTitle("Manager Report");
		}
		else if(e.getSource() == runEFTBtn) {
			clear();
			main.add(EFTPanel);
			populateProviderComboBox(EFTChoiceBox);
			addFooterButton(runEFTReportChoiceBtn);
			setTitle("EFT");
		}
		else if(e.getSource() == runSummaryReportBtn) {
			clear();
			main.add(summaryReportPanel);
			addFooterButton(summaryReportBackBtn);
			setTitle("Summary Report");
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
				//TODO change this to getName()
				comboBox.addItem(String.valueOf(((Provider)employee).getId()));
			}
		}
	}
	private Member getSelectedMember() {
		String selectedMemberName = (String) memberChoiceBox.getSelectedItem();
		return terminal.getMemberByName(selectedMemberName);
	}
	
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
