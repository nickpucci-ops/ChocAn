package project4;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import project4.layouts.Login;
import project4.layouts.MainAccountingProcedure;
import project4.layouts.ManagerMenu;
import project4.layouts.OperatorMenu;
import project4.report.*;
import project4.json.EmployeeAdapter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class Terminal implements ActionListener {
	
	ArrayList<Employee> employees;
	ArrayList<Member> members;
	
	Employee loggedInEmployee;
	
	JFrame mainWindow;
	
	Login loginPanel;
	OperatorMenu operatorMenuPanel;
	MainAccountingProcedure mainAccountingPanel;
	ManagerMenu managerMenuPanel;
	
	
	Terminal() {
		mainWindow = new JFrame();
		
		readData();
		
		//MemberReport testReport = new MemberReport(members.get(0), "memReport.pdf");
		//testReport.open();				

		ProviderReport TestProvider = new ProviderReport(new Provider(1, "provider1"), "test3.pdf"); 
		TestProvider.open(); 
		
		operatorMenuPanel = new OperatorMenu(this);
		mainAccountingPanel = new MainAccountingProcedure(this);
		managerMenuPanel = new ManagerMenu(this);
		
		loginPanel = new Login(this);
		mainWindow.add(loginPanel);
		
		//set mainWindow properties
		mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				writeData();
				mainWindow.dispose();
			}
		});		
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
	
	public Boolean verifyEmployee(String username, String pwd) throws NumberFormatException {
		short employeeType = -1;
		for(Employee employee : employees) {
			if(employee.getUsername().equals(username)) {
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
			mainWindow.remove(loginPanel);
			mainWindow.add(managerMenuPanel);
			mainWindow.revalidate();
			mainWindow.repaint();
		} else if(employeeType == Employee.PROVIDER) {
			//TODO: show provider menu
		}
		return true;
	}
	
	private void readData() {
		try(JsonReader reader = new JsonReader(new FileReader("members.json"))) {
			Gson gson = new GsonBuilder().create();
			
			members = new ArrayList<Member>(Arrays.asList(gson.fromJson(reader, Member[].class)));
			//List memberObject = (List) Arrays.asList(gson.fromJson(reader, Member[].class));
			//members.add(memberObject.);
		} catch (FileNotFoundException e) {
			members = new ArrayList<Member>();
			members.add(new Member("Joe Schmoe", 1, "123 Main Street", "Tuscaloosa", "AL", 12345));
			members.add(new Member("Bob", 2, "456 Main Street", "Seattle", "WA", 56482));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(JsonReader reader = new JsonReader(new FileReader("employees.json"))) {
			employees = new ArrayList<Employee>();
			Gson gson = (new GsonBuilder()).registerTypeAdapter(employees.getClass(), new EmployeeAdapter()).create();	
			employees = gson.fromJson(reader, employees.getClass());
		} catch (FileNotFoundException e) {
			employees = new ArrayList<Employee>();
			employees.add(new Operator(1, "operator1"));	
			employees.add(new Manager(2, "manager1"));
		} catch(JsonSyntaxException e) {
			employees = new ArrayList<Employee>();
			employees.add(new Operator(1, "operator1"));
			employees.add(new Manager(2, "manager1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeData() {
		try(Writer writer = new FileWriter("members.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(members, writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Writer writer = new FileWriter("employees.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(employees, writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		return members.get(0);
	}
}
