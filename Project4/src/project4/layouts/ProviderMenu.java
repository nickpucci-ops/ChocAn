package project4.layouts;
import java.awt.*;
import javax.swing.*;

//import project4.Employee;
import project4.Terminal;
//import project4.Member;
//import project4.Provider;

public class ProviderMenu extends Menu implements ActionListener {
	/*
	 * 
	 */
//	private static String user;
//	private static String password;
	
	JPanel mainMenuPanel;
	JButton requestProviderDirectoryBtn;
	JButton billChocAnBtn;
	
	JPanel providerDirectoryPanel;
	JButton providerDirectoryBackBtn;
	
	JPanel billChocAnPanel;
	JLabel 
	JButton submitDataBtn;
	JButton billChocAnBackBtn;
	
//	JPanel addMemberPanel;
//	JLabel addMemberNameLabel;
//	JTextField addMemberNameText;
//	JLabel addMemberAddressLabel;
//	JTextField addMemberAddressText;
//	JLabel addMemberCityLabel;
//	JTextField addMemberCityText;
//	JLabel addMemberZipLabel;
//	JTextField addMemberZipText;
//	JButton addMemberCancelBtn;
//	JButton addMemberSubmitBtn;
	
	
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
		//look up 6 digit service id number
		providerDirectoryBackBtn = new JButton("Back");
		providerDirectoryBackBtn.addActionListener(this);
		providerDirectoryPanel.add(providerDirectoryBackBtn);
		
		billChocAnPanel = new JPanel();
		//enter member id
		//enter service data
		submitDataBtn = new JButton("Submit");
		submitDataBtn.addActionListener(this);
		billChocAnPanel.add(submitDataBtn);
		billChocAnBackBtn = new JButton("Back");
		billChocAnBackBtn.addActionListener(this);
		billChocAnPanel.add(billChocAnBackBtn);
		
//		addMemberPanel = new JPanel(new GridLayout(0, 2));
//		addMemberNameLabel = new JLabel("Name: ");
//		addMemberPanel.add(addMemberNameLabel);
//		addMemberNameText = new JTextField(16);
//		addMemberPanel.add(addMemberNameText);
//		addMemberAddressLabel = new JLabel("Address: ");
//		addMemberPanel.add(addMemberAddressLabel);
//		addMemberAddressText = new JTextField(16);
//		addMemberPanel.add(addMemberAddressText);
//		addMemberCityLabel = new JLabel("City: ");
//		addMemberPanel.add(addMemberCityLabel);
//		addMemberCityText = new JTextField(16);
//		addMemberPanel.add(addMemberCityText);
//		addMemberZipLabel = new JLabel("Zip Code: ");
//		addMemberPanel.add(addMemberZipLabel);
//		addMemberZipText = new JTextField(16);
//		addMemberPanel.add(addMemberZipText);
//		addMemberCancelBtn = new JButton("Cancel");
//		addMemberCancelBtn.addActionListener(this);
//		addMemberSubmitBtn = new JButton("Submit");
//		addMemberSubmitBtn.addActionListener(this);
		
		public int validateMemberID(String memberID) {
			for(Member member : members) {
				if (member.getID() == Integer.parseInt(memberID)) {
					return 1;
				} else {
					return 0; //member not verified
				}
			}
			return 0;
		}
	}
}