package project4.layouts;
import javax.swing.*;

import project4.Terminal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6272938054028176768L;
	
	Terminal terminal;
	JLabel userNameLabel;
	JLabel passwordLabel;
	JTextField userNameText;
	JPasswordField passwordText;
	JButton submitBtn;
	
	JButton mainAccountingProcedureBtn;
	
	public Login(Terminal terminal) {
		super();
		this.terminal = terminal;
		GridBagConstraints c = new GridBagConstraints();
		
		this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.setLayout(new GridBagLayout());
		
		userNameLabel = new JLabel("Username: ");
		c.gridx = 0;
		c.gridy = 0;
		this.add(userNameLabel, c);
		
		passwordLabel = new JLabel("Password: ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(passwordLabel, c);
		
		userNameText = new JTextField(16);
		c.gridx = 1;
		c.gridy = 0;
		this.add(userNameText, c);
		
		passwordText = new JPasswordField(16);
		c.gridx = 1;
		c.gridy = 1;
		this.add(passwordText, c);
		
		submitBtn = new JButton("Log in");
		submitBtn.addActionListener(this);		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(submitBtn, c);
		
		mainAccountingProcedureBtn = new JButton("Run Main Accounting Procedure");
		mainAccountingProcedureBtn.addActionListener(terminal);
		c.gridx = 0;
		c.gridy = 3;
		this.add(mainAccountingProcedureBtn, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == submitBtn) {
			String username = userNameText.getText();
			String password = String.valueOf(passwordText.getPassword());
			if(username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter BOTH a username AND a password", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!terminal.verifyEmployee(username, password)) {
				JOptionPane.showMessageDialog(this, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}	
	
}
