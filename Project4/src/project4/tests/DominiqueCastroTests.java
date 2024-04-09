package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project4.*;

class DominiqueCastroTests {
    Terminal terminal;
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
	}

    @Test
    void testMatchingCardNum() {
    	ArrayList<Employee> employees = terminal.getEmployees();
		Operator operator = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.OPERATOR) {
				operator = (Operator)employee;
				break;
			}
		}
		Assertions.assertTrue(operator != null);
		operator.addMember(terminal, new Member("Billy Joe", 123, "123 Main Street", "Tuscaloosa", "AL", 35405));
        Card card = new Card("Billy Joe", 123);
        Assertions.assertTrue(terminal.getMemberByName("Billy Joe").getMemberNumber() == card.getMemberNumber());
    }

    @Test
    void testMatchingCardName() {
    	ArrayList<Employee> employees = terminal.getEmployees();
		Operator operator = null;
		for(Employee employee : employees) {
			if(employee.getEmployeeType() == Employee.OPERATOR) {
				operator = (Operator)employee;
				break;
			}
		}
		Assertions.assertTrue(operator != null);
		operator.addMember(terminal, new Member("Billy Joe", 123, "123 Main Street", "Tuscaloosa", "AL", 35405));
        Card card = new Card("Billy Joe", 123);
        Assertions.assertTrue(("Billy Joe") == card.getMemberName());
    
    }

    @Test
    void testProviderName() {
    	Provider provider = new Provider(123, "Provider1", "Joe Joe", 16, "123 Main Street", "Tuscaloosa", "AL", 35405);
		String Name = provider.getName();
		Assertions.assertTrue(Name == "Joe Joe");
	}
}
