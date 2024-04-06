package project4.layouts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import project4.*;

public class OperatorMenu extends Menu implements ActionListener {
	
	private static final long serialVersionUID = 7059180387276164616L;
	
	JPanel mainMenuPanel;
	JButton editMembersBtn;
	JButton editProvidersBtn;
	
	JPanel editMembersPanel;
	JButton addMemberBtn;
	JButton updateMemberBtn;
	JButton deleteMemberBtn;
	JButton editMembersBackBtn;
	
	JPanel editProvidersPanel;
	JButton addProviderBtn;
	JButton updateProviderBtn;
	JButton deleteProviderBtn;
	JButton editProvidersBackBtn;
	
	JPanel addMemberPanel;
	JLabel addMemberNameLabel;
	JTextField addMemberNameText;
	JLabel addMemberAddressLabel;
	JTextField addMemberAddressText;
	JLabel addMemberCityLabel;
	JTextField addMemberCityText;
	JLabel addMemberZipLabel;
	JTextField addMemberZipText;
	JButton addMemberCancelBtn;
	JButton addMemberSubmitBtn;
	
	JPanel updateMemberChoicePanel;
	JLabel updateMemberChoiceLabel;
	JComboBox<String> updateMemberChoiceBox;
	JButton updateMemberChoiceSubmitBtn;
	
	JPanel updateMemberPanel;
	JLabel updateMemberNameLabel;
	JTextField updateMemberNameText;
	JLabel updateMemberAddressLabel;
	JTextField updateMemberAddressText;
	JLabel updateMemberCityLabel;
	JTextField updateMemberCityText;
	JLabel updateMemberZipLabel;
	JTextField updateMemberZipText;
	JButton updateMemberCancelBtn;
	JButton updateMemberSubmitBtn;

	public OperatorMenu(Terminal terminal) {
		super(terminal);		
		this.setTitle("Operator");
		
		mainMenuPanel = new JPanel();
		editMembersBtn = new JButton("Edit Members");
		editMembersBtn.addActionListener(this);
		mainMenuPanel.add(editMembersBtn);
		editProvidersBtn = new JButton("Edit Providers");
		editProvidersBtn.addActionListener(this);
		mainMenuPanel.add(editProvidersBtn);
		main.add(mainMenuPanel);
		
		editMembersPanel = new JPanel();
		addMemberBtn = new JButton("Add Member");
		addMemberBtn.addActionListener(this);
		editMembersPanel.add(addMemberBtn);
		updateMemberBtn = new JButton("Update Member");
		updateMemberBtn.addActionListener(this);
		editMembersPanel.add(updateMemberBtn);
		deleteMemberBtn = new JButton("Delete Member");
		deleteMemberBtn.addActionListener(this);
		editMembersPanel.add(deleteMemberBtn);
		editMembersBackBtn = new JButton("Back");
		editMembersBackBtn.addActionListener(this);
		
		editProvidersPanel = new JPanel();
		addProviderBtn = new JButton("Add Provider");
		editProvidersPanel.add(addProviderBtn);
		updateProviderBtn = new JButton("Update Provider");
		editProvidersPanel.add(updateProviderBtn);
		deleteProviderBtn = new JButton("Delete Provider");
		editProvidersPanel.add(deleteProviderBtn);
		editProvidersBackBtn = new JButton("Back");
		editProvidersBackBtn.addActionListener(this);
		
		addMemberPanel = new JPanel(new GridLayout(0, 2));
		addMemberNameLabel = new JLabel("Name: ");
		addMemberPanel.add(addMemberNameLabel);
		addMemberNameText = new JTextField(16);
		addMemberPanel.add(addMemberNameText);
		addMemberAddressLabel = new JLabel("Address: ");
		addMemberPanel.add(addMemberAddressLabel);
		addMemberAddressText = new JTextField(16);
		addMemberPanel.add(addMemberAddressText);
		addMemberCityLabel = new JLabel("City: ");
		addMemberPanel.add(addMemberCityLabel);
		addMemberCityText = new JTextField(16);
		addMemberPanel.add(addMemberCityText);
		addMemberZipLabel = new JLabel("Zip Code: ");
		addMemberPanel.add(addMemberZipLabel);
		addMemberZipText = new JTextField(16);
		addMemberPanel.add(addMemberZipText);
		addMemberCancelBtn = new JButton("Cancel");
		addMemberCancelBtn.addActionListener(this);
		addMemberSubmitBtn = new JButton("Submit");
		addMemberSubmitBtn.addActionListener(this);
		
		updateMemberChoicePanel = new JPanel();
		updateMemberChoiceLabel = new JLabel("Choose Member to update: ");
		updateMemberChoicePanel.add(updateMemberChoiceLabel);
		updateMemberChoiceBox = new JComboBox<String>();
		populateMemberComboBox(updateMemberChoiceBox);
		updateMemberChoicePanel.add(updateMemberChoiceBox);
		updateMemberChoiceSubmitBtn = new JButton("Update");
		updateMemberChoiceSubmitBtn.addActionListener(this);
		
		updateMemberPanel = new JPanel(new GridLayout(0, 2));
		updateMemberNameLabel = new JLabel("Name: ");
		updateMemberPanel.add(updateMemberNameLabel);
		updateMemberNameText = new JTextField(16);
		updateMemberPanel.add(updateMemberNameText);
		updateMemberAddressLabel = new JLabel("Address: ");
		updateMemberPanel.add(updateMemberAddressLabel);
		updateMemberAddressText = new JTextField(16);
		updateMemberPanel.add(updateMemberAddressText);
		updateMemberCityLabel = new JLabel("City: ");
		updateMemberPanel.add(updateMemberCityLabel);
		updateMemberCityText = new JTextField(16);
		updateMemberPanel.add(updateMemberCityText);
		updateMemberZipLabel = new JLabel("Zip Code: ");
		updateMemberPanel.add(updateMemberZipLabel);
		updateMemberZipText = new JTextField(16);
		updateMemberPanel.add(updateMemberZipText);
		updateMemberCancelBtn = new JButton("Cancel");
		updateMemberCancelBtn.addActionListener(this);
		updateMemberSubmitBtn = new JButton("Submit");
		updateMemberSubmitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == editMembersBtn) {
			clear();
			main.add(editMembersPanel);
			addFooterButton(editMembersBackBtn);
			setTitle("Edit Members");
		} else if(e.getSource() == editProvidersBtn) {
			clear();
			main.add(editProvidersPanel);
			addFooterButton(editProvidersBackBtn);
			setTitle("Edit Providers");
		} else if(e.getSource() == addMemberBtn) {
			clear();
			main.add(addMemberPanel);
			addFooterButton(addMemberSubmitBtn);
			addFooterButton(addMemberCancelBtn);
			setTitle("Add Member");
		} else if(e.getSource() == updateMemberBtn) {
			clear();
			main.add(updateMemberChoicePanel);
			addFooterButton(updateMemberChoiceSubmitBtn);
			setTitle("Select Member");
		} else if(e.getSource() == deleteMemberBtn) { 
			
		} else if(e.getSource() == addMemberCancelBtn) {
			clear();
			main.add(editMembersPanel);
			setTitle("Edit Members");
		} else if(e.getSource() == addMemberSubmitBtn) {			
			if(!validateAddMemberFields()) {
				JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);;;;;;;;;;;;;
			} else {
				Member newMember = createMemberFromAddMemberFields(terminal.getMembers().getLast().getMemberNumber() + 1);
				((Operator)terminal.getLoggedInEmployee()).addMember(newMember);
			}
		} else if(e.getSource() == updateMemberChoiceSubmitBtn) {
			clear();
			main.add(updateMemberPanel);
			populateUpdateMemberFields();
			addFooterButton(updateMemberSubmitBtn);
			addFooterButton(updateMemberCancelBtn);
			setTitle("Update Member");
		} else if(e.getSource() == getLogoutBtn()) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Operator");
		}
		else {
			clear();
			main.add(mainMenuPanel);
			setTitle("Operator");
		}
		main.revalidate();
		main.repaint();
	}
	
	private void populateMemberComboBox(JComboBox<String> comboBox) {
		for(Member member : terminal.getMembers()) {
			comboBox.addItem(member.getName());
		}
	}
	
	private void populateUpdateMemberFields() {
		Member memberToEdit = terminal.getMemberByName((String)updateMemberChoiceBox.getSelectedItem());
		updateMemberNameText.setText(memberToEdit.getName());
		updateMemberAddressText.setText(memberToEdit.getStreetAddress());
		updateMemberCityText.setText(memberToEdit.getCity());
		updateMemberZipText.setText(String.valueOf(memberToEdit.getZipCode()));
	}
	
	private Boolean validateAddMemberFields() {
		if(addMemberNameText.getText().isEmpty()) {
			return false;
		}
		if(addMemberAddressText.getText().isEmpty()) {
			return false;
		}
		if(addMemberCityText.getText().isEmpty()) {
			return false;
		}
		if(addMemberZipText.getText().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private Member createMemberFromAddMemberFields(int id) {
		return new Member(addMemberNameText.getText(), id, addMemberAddressText.getText(), 
				addMemberCityText.getText(), addMemberCityText.getText(), Integer.parseInt(addMemberZipText.getText()));
	}

}
