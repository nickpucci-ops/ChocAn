package project4.layouts;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map.Entry;

import javax.swing.*;

import project4.Terminal;
import project4.Employee;
import project4.Member;
import project4.Provider;
import project4.Service;

/*
 * Provider Menu class extending from the Menu class
 * 
 * @author Nick
 * @version 1.0
 */
public class ProviderMenu extends Menu implements ActionListener {

	private static final long serialVersionUID = -2673515052420890046L;
	JPanel mainMenuPanel;
	JButton requestProviderDirectoryBtn;
	JButton billChocAnBtn;
	
	JPanel providerDirectoryPanel;
	JButton providerDirectoryBackBtn;
	
	JPanel billChocAnPanel;
	JLabel addDateOfServiceLabel;
	JTextField addDateOfServiceText;
	JLabel addProviderNumberLabel;
	JTextField addProviderNumberText;
	JLabel addMemeberNumberLabel;
	JTextField addMemeberNumberText;
	JLabel addServiceCodeLabel;
	JTextField addServiceCodeText;
	
	JLabel addFeeLabel;
	JTextField addFeeText;
	JLabel addCommentsLabel;
	JTextField addCommentsText;
	JButton submitDataBtn;
	JButton billChocAnCancelBtn;
	
	/*
	 * Create new provider menu from terminal
	 * @param terminal the current terminal
	 */
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
		providerDirectoryBackBtn = new JButton("Back");
		providerDirectoryBackBtn.addActionListener(this);
		providerDirectoryPanel.add(providerDirectoryBackBtn);
		
		billChocAnPanel = new JPanel(new GridLayout(0, 2));
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
		//fees
		addFeeLabel = new JLabel("Fee: ");
		billChocAnPanel.add(addFeeLabel);
		addFeeText = new JTextField(16);
		billChocAnPanel.add(addFeeText);
		//comments
		addCommentsLabel = new JLabel("Comments: ");
		billChocAnPanel.add(addCommentsLabel);
		addCommentsText = new JTextField(16);
		billChocAnPanel.add(addCommentsText);
		//submit
		submitDataBtn = new JButton("Submit");
		submitDataBtn.addActionListener(this);
		//billChocAnPanel.add(submitDataBtn);
		//back
		billChocAnCancelBtn = new JButton("Cancel");
		billChocAnCancelBtn.addActionListener(this);
		//billChocAnPanel.add(billChocAnCancelBtn);		
		
	}

	/*
	 * Method to read if any button has been activated and then produce the desired output
	 * @param e the action event received
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == requestProviderDirectoryBtn) {
			((Provider)terminal.getLoggedInEmployee()).getProviderDirectory(terminal);
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
			if(validateBillChocAnFields() && validateMemberNumber(addMemeberNumberText.getText()) 
					&& validateProviderNumber(addProviderNumberText.getText()) 
					&& validateServiceCode(addServiceCodeText.getText())) {
				((Provider)terminal.getLoggedInEmployee()).createNewServiceRecord(terminal, addDateOfServiceText.getText(), 
						addProviderNumberText.getText(), addMemeberNumberText.getText(),
						addServiceCodeText.getText(), addFeeText.getText(), addCommentsText.getText());
				
				clear();
				main.add(mainMenuPanel);
				setTitle("Provider");
			}
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
	
	/*
	 * Confirm that all fields have been entered in to correctly before submission
	 */
	private Boolean validateBillChocAnFields() {
		if(addDateOfServiceText.getText().isEmpty() || addProviderNumberText.getText().isEmpty() ||
				addMemeberNumberText.getText().isEmpty() || addServiceCodeText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addServiceCodeText.getText().length() != 6) {
			JOptionPane.showMessageDialog(this, "The service code field must be 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(addServiceCodeText.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "The service code field must be 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/*
	 * Confirm that the member number entered exists
	 * @param memberID the member number entered by the user
	 */
	private Boolean validateMemberNumber(String memberID) {
		for(Member member : terminal.getMembers()) {
			if (member.getMemberNumber() == Integer.parseInt(memberID)) {
				return true;
			} 
		}
		JOptionPane.showMessageDialog(this, "Invalid Member Number", "Error", JOptionPane.ERROR_MESSAGE);
		return false; //member not verified
	}
	
	/*
	 * Confirm that the provider number entered exists
	 * @param providerID the provider number entered by the user
	 */
	private Boolean validateProviderNumber(String providerID){
		for(Employee employee : terminal.getEmployees()) {
			if (employee.getEmployeeType() == Employee.PROVIDER && ((Provider)employee).getProviderNumber() == Integer.parseInt(providerID)) {
				return true;
			} 
		}
		JOptionPane.showMessageDialog(this, "Invalid Provider Number", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	/*
	 * Confirm that the service code entered exists
	 * @param serviceCode the service code entered by the user
	 */
	private Boolean validateServiceCode(String serviceCode) {
		for(Entry<Integer, String> e : terminal.getServiceCodes().entrySet()) {
			if(e.getKey() == Integer.parseInt(serviceCode)) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(this, "Invalid Service Code", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
}