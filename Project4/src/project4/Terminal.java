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
		
		employees = new ArrayList<Employee>();
		employees.add(new Operator(this, 1));
		members = new ArrayList<Member>();
		members.add(new Member("Joe Schmoe", 1, "123 Main Street", "Tuscaloosa", "AL", 12345));
		members.add(new Member("Bob", 2, "456 Main Street", "Seattle", "WA", 56482));
		
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
		
		
	}
	
	public static void main(String[] args) {
		
		new Terminal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Log out")) {			
			mainWindow.getContentPane().removeAll();
			mainWindow.add(loginPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(s.equals("Run Main Accounting Procedure")) {
			mainWindow.remove(loginPanel);
			mainAccountingPanel.MainAccountingStart();
			mainWindow.add(mainAccountingPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		}
		
	}
	
	public Boolean verifyEmployee(String id, String pwd) {
		short employeeType = -1;
		for(Employee employee : employees) {
			if(employee.getId() == Integer.parseInt(id)) {
				if(employee.getPassword().equals(pwd)) {
					loggedInEmployee = employee;
					employeeType = employee.getEmployeeType();
				} else {
					//invalid log in -- wrong password
					return false;
				}
			}
		}
		//invalid log in -- no user matches id
		if(employeeType == -1) {
			return false;
		}
		if(employeeType == Employee.OPERATOR) {
			mainWindow.remove(loginPanel);
			mainWindow.add(operatorMenuPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(employeeType == Employee.MANAGER) {
			//TODO: show manager menu
		} else if(employeeType == Employee.PROVIDER) {
			//TODO: show provider menu
		}
		return true;
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
	
	public Employee getLoggedInEmployee() {
		return loggedInEmployee;
	}
	
	public Member getMemberByName(String name) {
		for(Member member : members) {
			if(member.getName().equals(name)) {
				return member;
			}
		}
		return members.getFirst();
	}
}
