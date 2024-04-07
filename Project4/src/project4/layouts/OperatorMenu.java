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
	JLabel addMemberStateLabel;
	JTextField addMemberStateText;
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
	JLabel updateMemberStateLabel;
	JTextField updateMemberStateText;
	JLabel updateMemberZipLabel;
	JTextField updateMemberZipText;
	JButton updateMemberCancelBtn;
	JButton updateMemberSubmitBtn;
	
	JPanel deleteMemberPanel;
	JLabel deleteMemberChoiceLabel;
	JComboBox<String> deleteMemberChoiceBox;
	JButton deleteMemberSubmitBtn;
	JButton deleteMemberCancelBtn;

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
		addMemberStateLabel = new JLabel("State: ");
		addMemberPanel.add(addMemberStateLabel);
		addMemberStateText = new JTextField(16);
		addMemberPanel.add(addMemberStateText);
		addMemberZipLabel = new JLabel("Zip Code: ");
		addMemberPanel.add(addMemberZipLabel);
		addMemberZipText = new JTextField(16);
		addMemberPanel.add(addMemberZipText);
		addMemberCancelBtn = new JButton("Cancel");
		addMemberCancelBtn.addActionListener(this);
		addMemberSubmitBtn = new JButton("Submit");
		addMemberSubmitBtn.addActionListener(this);
		
		updateMemberChoicePanel = new JPanel();
		updateMemberChoiceLabel = new JLabel("Choose member to update: ");
		updateMemberChoicePanel.add(updateMemberChoiceLabel);
		updateMemberChoiceBox = new JComboBox<String>();
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
		updateMemberStateLabel = new JLabel("State: ");
		updateMemberPanel.add(updateMemberStateLabel);
		updateMemberStateText = new JTextField(16);
		updateMemberPanel.add(updateMemberStateText);
		updateMemberZipLabel = new JLabel("Zip Code: ");
		updateMemberPanel.add(updateMemberZipLabel);
		updateMemberZipText = new JTextField(16);
		updateMemberPanel.add(updateMemberZipText);
		updateMemberCancelBtn = new JButton("Cancel");
		updateMemberCancelBtn.addActionListener(this);
		updateMemberSubmitBtn = new JButton("Submit");
		updateMemberSubmitBtn.addActionListener(this);
		
		deleteMemberPanel = new JPanel();
		deleteMemberChoiceLabel = new JLabel("Choose member to delete: ");
		deleteMemberPanel.add(deleteMemberChoiceLabel);
		deleteMemberChoiceBox = new JComboBox<String>();
		deleteMemberPanel.add(deleteMemberChoiceBox);
		deleteMemberSubmitBtn = new JButton("Delete");
		deleteMemberSubmitBtn.addActionListener(this);
		deleteMemberCancelBtn = new JButton("Cancel");
		deleteMemberCancelBtn.addActionListener(this);
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
			populateMemberComboBox(updateMemberChoiceBox);
			addFooterButton(updateMemberChoiceSubmitBtn);
			setTitle("Select Member");
		} else if(e.getSource() == deleteMemberBtn) { 
			clear();
			main.add(deleteMemberPanel);
			populateMemberComboBox(deleteMemberChoiceBox);
			addFooterButton(deleteMemberSubmitBtn);
			addFooterButton(deleteMemberCancelBtn);
			setTitle("Delete Member");
		} else if(e.getSource() == addMemberCancelBtn) {
			clear();
			main.add(editMembersPanel);
			setTitle("Edit Members");
		} else if(e.getSource() == addMemberSubmitBtn) {			
			if(validateAddMemberFields()) {
				Member newMember = createMemberFromAddMemberFields(terminal.getMembers().getLast().getMemberNumber() + 1);
				((Operator)terminal.getLoggedInEmployee()).addMember(terminal, newMember);
				clear();
				main.add(editMembersPanel);
				setTitle("Edit Members");
			} 
		} else if(e.getSource() == updateMemberChoiceSubmitBtn) {
			clear();
			main.add(updateMemberPanel);
			populateUpdateMemberFields();
			addFooterButton(updateMemberSubmitBtn);
			addFooterButton(updateMemberCancelBtn);
			setTitle("Update Member");
		} else if(e.getSource() == updateMemberSubmitBtn) {
			if(validateUpdateMemberFields()) {
				Member updatedMember = createMemberFromUpdateMemberFields();
				((Operator)terminal.getLoggedInEmployee()).editMember(terminal, updatedMember);
				clear();
				main.add(editMembersPanel);
				setTitle("Edit Members");
			} 
		} else if(e.getSource() == deleteMemberSubmitBtn) {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + deleteMemberChoiceBox.getSelectedItem() + "? This action cannot be undone!", "Delete Member", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.OK_OPTION) {
				((Operator)terminal.getLoggedInEmployee()).removeMember(terminal, terminal.getMemberByName((String)deleteMemberChoiceBox.getSelectedItem()));
				clear();
				main.add(editMembersPanel);
				setTitle("Edit Members");
			} 
		} else if(e.getSource() == deleteMemberCancelBtn) {
			clear();
			main.add(editMembersPanel);
			setTitle("Edit Members");
		} else if(e.getSource() == getLogoutBtn()) {
			clear();
			main.add(mainMenuPanel);
			setTitle("Operator");
		} else {
			clear();
			main.add(mainMenuPanel);
			setTitle("Operator");
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
	
	private void populateUpdateMemberFields() {
		Member memberToEdit = terminal.getMemberByName((String)updateMemberChoiceBox.getSelectedItem());
		updateMemberNameText.setText(memberToEdit.getName());
		updateMemberAddressText.setText(memberToEdit.getStreetAddress());
		updateMemberCityText.setText(memberToEdit.getCity());
		updateMemberStateText.setText(memberToEdit.getState());
		updateMemberZipText.setText(String.valueOf(memberToEdit.getZipCode()));
	}
	
	private Boolean validateAddMemberFields() {
		if(addMemberNameText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}		
		if(addMemberAddressText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberCityText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberStateText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberZipText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberNameText.getText().length() > 25) {
			JOptionPane.showMessageDialog(this, "Name field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberAddressText.getText().length() > 25) {
			JOptionPane.showMessageDialog(this, "Address field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberCityText.getText().length() > 14) {
			JOptionPane.showMessageDialog(this, "City field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberStateText.getText().length() > 2) {
			JOptionPane.showMessageDialog(this, "State field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(addMemberZipText.getText().length() != 5) {
			JOptionPane.showMessageDialog(this, "The zip code field must be 5 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(addMemberZipText.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "The zip code field must be 5 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private Member createMemberFromAddMemberFields(int id) {
		return new Member(addMemberNameText.getText(), id, addMemberAddressText.getText(), 
				addMemberCityText.getText(), addMemberStateText.getText(), Integer.parseInt(addMemberZipText.getText()));
	}
	
	private Boolean validateUpdateMemberFields() {
		if(updateMemberNameText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberAddressText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberCityText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberStateText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberZipText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberNameText.getText().length() > 25) {
			JOptionPane.showMessageDialog(this, "Name field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberAddressText.getText().length() > 25) {
			JOptionPane.showMessageDialog(this, "Address field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberCityText.getText().length() > 14) {
			JOptionPane.showMessageDialog(this, "City field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberStateText.getText().length() > 2) {
			JOptionPane.showMessageDialog(this, "State field is too long!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(updateMemberZipText.getText().length() != 5) {
			JOptionPane.showMessageDialog(this, "The zip code field must be 5 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(updateMemberZipText.getText());
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "The zip code field must be 5 digits", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private Member createMemberFromUpdateMemberFields() {
		return new Member(updateMemberNameText.getText(), terminal.getMemberByName((String)updateMemberChoiceBox.getSelectedItem()).getMemberNumber(), updateMemberAddressText.getText(), 
				updateMemberCityText.getText(), updateMemberStateText.getText(), Integer.parseInt(updateMemberZipText.getText()));
	}

}
