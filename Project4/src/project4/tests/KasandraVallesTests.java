package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import project4.Terminal;

public class KasandraVallesTests {
	Terminal terminal;
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
	}
	
	@Test
	void testGetProviderReport() {
		ArrayList<Employee> employees = terminal.getEmployees();
        Provider provider = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeType() == Employee.PROVIDER) {
                provider = (Provider) employee;
                break;
            }
        }
        Assertions.assertTrue(provider != null);

        Manager manager = null;
        for (Employee employee : employees) {
            if (employee.getEmployeeType() == Employee.MANAGER) {
                manager = (Manager) employee;
                break;
            }
        }
        Assertions.assertTrue(manager != null);

        manager.getProviderReport(terminal, provider);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
        String expectedFileName = provider.getName() + " - " + formatter.format(LocalDateTime.now()) + ".pdf";
        assertTrue(terminal.reportExists(expectedFileName));
	}
	
	@Test
    void testGetSummaryReport() {
        Manager manager = null;
        for (Employee employee : terminal.getEmployees()) {
            if (employee.getEmployeeType() == Employee.MANAGER) {
                manager = (Manager) employee;
                break;
            }
        }
        Assertions.assertTrue(manager != null);

        manager.getSummaryReport(terminal);
        assertTrue(terminal.reportExists("summary.pdf"));
    }
	
	@Test
    void testGetProviderDirectory() {
        ProviderDirectory providerDirectory = provider.getProviderDirectory();
        assertNotNull(providerDirectory);
    }
}
