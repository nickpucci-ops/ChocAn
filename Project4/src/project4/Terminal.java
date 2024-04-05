package project4;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import project4.layouts.Login;
import project4.layouts.MainAccountingProcedure;
import project4.layouts.OperatorMenu;

public class Terminal implements ActionListener {
	
	ArrayList<Employee> employees;
	ArrayList<Member> members;
	
	Employee loggedInEmployee;
	
	JFrame mainWindow;
	
	Login loginPanel;
	OperatorMenu operatorMenuPanel;
	MainAccountingProcedure mainAccountingPanel;
	
	Terminal() {
		mainWindow = new JFrame();
		
		operatorMenuPanel = new OperatorMenu(this);
		mainAccountingPanel = new MainAccountingProcedure(this);
		
		loginPanel = new Login(this);
		mainWindow.add(loginPanel);
		
		//set mainWindow properties
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(new Dimension(500, 300));
		mainWindow.setTitle("ChocAn");
		//mainWindow.pack();
		mainWindow.setVisible(true);
		
		employees = new ArrayList<Employee>();
		members = new ArrayList<Member>();
	}
	
	public static void main(String[] args) {
		
		new Terminal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Log in")) {
			JButton logInBtn = (JButton)e.getSource();
			int result = verifyEmployee((String)logInBtn.getClientProperty("id"), (String)logInBtn.getClientProperty("password"));	
			if(result == 0) {
				//TODO: handle invalid log in
				//for now, just go to operator menu
				mainWindow.remove(loginPanel);
				mainWindow.add(operatorMenuPanel);
				mainWindow.revalidate();
				mainWindow.repaint();
			} else if(result == Employee.OPERATOR) {
				mainWindow.remove(loginPanel);
				mainWindow.add(operatorMenuPanel);
				mainWindow.revalidate();
				mainWindow.repaint();
			} else if(result == Employee.MANAGER) {
				//TODO: show manager menu
			} else if(result == Employee.PROVIDER) {
				//TODO: show provider menu
			}
			
		} else if(s.equals("Log out")) {			
			mainWindow.getContentPane().removeAll();
			mainWindow.add(loginPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(s.equals("Run Main Accounting Procedure")) {
			mainWindow.remove(loginPanel);
			mainWindow.add(mainAccountingPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		
	}
	
	public int verifyEmployee(String id, String pwd) {
		for(Employee employee : employees) {
			if(employee.getId() == Integer.parseInt(id)) {
				if(employee.getPassword().equals(pwd)) {
					loggedInEmployee = employee;
					return employee.getEmployeeType();
				} else {
					//invalid log in -- wrong username and password
					return 0;
				}
			}
		}
		return 0;
	}
	
	public void resizeWindow() {
		mainWindow.validate();
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
}
