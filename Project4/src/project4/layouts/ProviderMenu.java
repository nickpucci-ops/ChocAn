package project4.layouts;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import project4.Terminal;
import project4.Member;
import project4.Provider;

public class ProviderMenu extends Menu implements ActionListener {

	private static final long serialVersionUID = -2673515052420890046L;
	JPanel mainMenuPanel;
	JButton requestProviderDirectoryBtn;
	JButton billChocAnBtn;
	
	JPanel providerDirectoryPanel;
	JButton providerDirectoryBackBtn;
	
	JPanel billChocAnPanel;
	JPanel addDateOfServicePanel;
	JLabel addDateOfServiceLabel;
	JTextField addDateOfServiceText;
	JPanel addProviderNumberPanel;
	JLabel addProviderNumberLabel;
	JTextField addProviderNumberText;
	JPanel addMemeberNumberPanel;
	JLabel addMemeberNumberLabel;
	JTextField addMemeberNumberText;
	JPanel addServiceCodePanel;
	JLabel addServiceCodeLabel;
	JTextField addServiceCodeText;
	JButton submitDataBtn;
	JButton billChocAnCancelBtn;
	
	
	
	public ProviderMenu(Terminal terminal) {
		super(terminal);
		this.setTitle("Provider");
		
		mainMenuPanel = new JPanel();
		requestProviderDirectoryBtn = new JButton("Request Provider Directory");
		requestProviderDirectoryBtn.addActionListener(this);
		mainMenuPanel.add(requestProviderDirectoryBtn);
		billChocAnBtn = new JButton("Bill ChocAn");
		billChocAnBtn.addActionListener(this);
		mainMenuPanel.add(billChocAnBtn);
		main.add(mainMenuPanel);
		
		providerDirectoryPanel = new JPanel();
		//display
		providerDirectoryBackBtn = new JButton("Back");
		providerDirectoryBackBtn.addActionListener(this);
		providerDirectoryPanel.add(providerDirectoryBackBtn);
		
		billChocAnPanel = new JPanel(new GridLayout(0, 2));
		//current date and time
		//
		//date service was provided
		addDateOfServiceLabel = new JLabel("Date of service(MM DD YYYY): ");
		billChocAnPanel.add(addDateOfServiceLabel);
		addDateOfServiceText = new JTextField(16);
		billChocAnPanel.add(addDateOfServiceText);
		//provider number
		addProviderNumberLabel = new JLabel("Provider #: ");
		billChocAnPanel.add(addProviderNumberLabel);
		addProviderNumberText = new JTextField(16);
		billChocAnPanel.add(addProviderNumberText);
		//member number
		addMemeberNumberLabel = new JLabel("Member #: ");
		billChocAnPanel.add(addMemeberNumberLabel);
		addMemeberNumberText = new JTextField(16);
		billChocAnPanel.add(addMemeberNumberText);
		//service code
		addServiceCodeLabel = new JLabel("Service Code: ");
		billChocAnPanel.add(addServiceCodeLabel);
		addServiceCodeText = new JTextField(6);
		billChocAnPanel.add(addServiceCodeText);
		//submit
		submitDataBtn = new JButton("Submit");
		submitDataBtn.addActionListener(this);
		billChocAnPanel.add(submitDataBtn);
		//back
		billChocAnCancelBtn = new JButton("Cancel");
		billChocAnCancelBtn.addActionListener(this);
		billChocAnPanel.add(billChocAnCancelBtn);
		
		
	}
	
	public int validateMemberID(String memberID) {
		for(Member member : terminal.getMembers()) {
			if (member.getMemberNumber() == Integer.parseInt(memberID)) {
				return 1;
			} else {
				return 0; //member not verified
			}
		}
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == requestProviderDirectoryBtn) {
			((Provider)terminal.getLoggedInEmployee()).getProviderDirectory();
		} else if(e.getSource() == providerDirectoryBackBtn) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Provider");
		} else if(e.getSource() == billChocAnBtn) {
			clear();
			main.add(billChocAnPanel);
			addFooterButton(billChocAnCancelBtn);
			addFooterButton(submitDataBtn);
			setTitle("Add Service Record");
		} else if(e.getSource() == billChocAnCancelBtn) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Provider");
		} else if(e.getSource() == submitDataBtn) {
			//if provider does not exist -> error
			//if member does not exist -> error
			//if service code does not exist -> error
			//else -> write to service records -> reset to provider menu
//			if(validateAddMemberFields()) {
//				Member newMember = createMemberFromAddMemberFields(terminal.getMembers().getLast().getMemberNumber() + 1);
//				((Operator)terminal.getLoggedInEmployee()).addMember(terminal, newMember);
//				clear();
//				main.add(editMembersPanel);
//				setTitle("Edit Members");
//			}
//			clear();
//			main.add(mainMenuPanel);
//			setTitle("Provider");
		} else if(e.getSource() == getLogoutBtn()) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Provider");
		}  else {
			clear();
			main.add(mainMenuPanel);
			setTitle("Provider");
		}
		main.revalidate();
		main.repaint();
	}
	
	
	
}