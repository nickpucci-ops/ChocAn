package project4.layouts;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project4.Terminal;

public class ManagerMenu extends Menu implements ActionListener {
	private static final long serialVersionUID = 7059180387276164616L;
	
	JPanel mainMenuPanel;
	JButton runMemberReportBtn;
	JButton runProviderReportBtn;
	JButton runManagerReportBtn;
	JButton runEFTBtn;
	
	JPanel memberReportPanel;
	JButton memberReportBackBtn;
	JPanel providerReportPanel;
	JButton providerReportBackBtn;
	JPanel managerReportPanel;
	JButton managerReportBackBtn;
	JPanel EFTPanel;
	JButton EFTBackBtn;
	
	public ManagerMenu(Terminal terminal) {
		super(terminal);		
		this.setTitle("Manager");
		
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
		main.add(mainMenuPanel);
		
		memberReportPanel = new JPanel();
		memberReportBackBtn = new JButton("Back");
		memberReportBackBtn.addActionListener(this);
		
		providerReportPanel = new JPanel();
		providerReportBackBtn = new JButton("Back");
		providerReportBackBtn.addActionListener(this);
		
		managerReportPanel = new JPanel();
		managerReportBackBtn = new JButton("Back");
		managerReportBackBtn.addActionListener(this);
		
		EFTPanel = new JPanel();
		EFTBackBtn = new JButton("Back");
		EFTBackBtn.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== runMemberReportBtn) {
			clear();
			main.add(memberReportPanel);
			addFooterButton(memberReportBackBtn);
			setTitle("Member Report");
		}
		else if(e.getSource() == runProviderReportBtn) {
			clear();
			main.add(providerReportPanel);
			addFooterButton(providerReportBackBtn);
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
			addFooterButton(EFTBackBtn);
			setTitle("EFT");
		}
	}
	
	
	
}
