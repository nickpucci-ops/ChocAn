package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project4.*;

class LoganMilletTests {
	Terminal terminal;
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
	}

	@Test
	void testAddMember() {
		ArrayList<Employee> employees = terminal.getEmployees();
		Operator operator = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.OPERATOR) {
				operator = (Operator)employee;
				break;
			}
		}
		Assertions.assertTrue(operator != null);
		operator.addMember(terminal, new Member("test member", 509, "123 Main Street", "Tuscaloosa", "AL", 45567));
		Assertions.assertTrue(terminal.getMemberByName("test member").getMemberNumber() == 509);
	}
	
	@Test
	void testAddProvider() {
		ArrayList<Employee> employees = terminal.getEmployees();
		Operator operator = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.OPERATOR) {
				operator = (Operator)employee;
				break;
			}
		}
		Assertions.assertTrue(operator != null);
		operator.addProvider(terminal, new Provider(678, "provider678", "test provider", 678, "123 Main Street", "Tuscaloosa", "AL", 34531));
		Assertions.assertTrue(terminal.getProviderByName("test provider").getId() == 678);
	}
	
	@Test
	void testGetMemberReport() {
		ArrayList<Employee> employees = terminal.getEmployees();
		Operator operator = null;
		Manager manager = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.OPERATOR) {
				operator = (Operator)employee;
				break;
			}
		}
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.MANAGER) {
				manager = (Manager)employee;
				break;
			}
		}
		Assertions.assertTrue(operator != null);
		Assertions.assertTrue(manager != null);
		Member newMember = new Member("test member", 509, "123 Main Street", "Tuscaloosa", "AL", 45567);
		operator.addMember(terminal, newMember);
		manager.getMemberReport(terminal, newMember);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
		File file = new File("reports/test member - " + formatter.format(LocalDateTime.now()) + ".pdf");
		Assertions.assertTrue(file.exists());
		Assertions.assertFalse(file.isDirectory());
	}

}
