package project4;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import project4.layouts.Login;
import project4.layouts.OperatorMenu;

public class Terminal implements ActionListener {
	
	JFrame mainWindow;
	
	Login loginPanel;
	OperatorMenu operatorMenuPanel;
	
	Terminal() {
		mainWindow = new JFrame();
		
		operatorMenuPanel = new OperatorMenu(this);
		
		loginPanel = new Login(this);
		mainWindow.add(loginPanel);
		
		//set mainWindow properties
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(new Dimension(500, 300));
		mainWindow.setTitle("ChocAn");
		//mainWindow.pack();
		mainWindow.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Terminal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Log in")) {
			int result = verifyEmployee();		
			mainWindow.remove(loginPanel);
			mainWindow.add(operatorMenuPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(s.equals("Log out")) {			
			mainWindow.getContentPane().removeAll();
			mainWindow.add(loginPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(s.equals("Run Main Accounting Procedure")) {
			//run main accounting procedure
		}
		
	}
	
	public int verifyEmployee() {
		return 0;
	}
	
	public void resizeWindow() {
		mainWindow.validate();
	}
}
