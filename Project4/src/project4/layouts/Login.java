package project4.layouts;
import javax.swing.*;

import project4.Terminal;

import java.awt.*;

public class Login extends JPanel {
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
		submitBtn.addActionListener(terminal);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(submitBtn, c);
	}
	
}
