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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
