package project4.report;

import java.util.ArrayList;

import project4.*;

public class SummaryReport extends Report {
	public SummaryReport(Terminal terminal, String filename) {
		super(filename, "Summary Report");
		float totalFee = 0;
		int totalConsultations = 0;
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getEmployeeType() == Employee.PROVIDER) {
				ArrayList<Service> providerServices = terminal.getServicesForProvider((Provider)employee);
				if(providerServices.size() >= 1) {
					addLineWithTitle("Provider: ", employee.getUsername());
					int numConsultations = 0;
					float totalProviderFee = 0;
					for(Service service : providerServices) {
						numConsultations++;
						totalProviderFee += service.getFee();
					}
					addLineWithTitle("Consultations:", String.valueOf(numConsultations));
					addLineWithTitle("Fee: ", String.format("$%.2f", totalProviderFee));
					totalFee += totalProviderFee;
					totalConsultations += numConsultations;
				}
				
			}
			addLine("");
		}
		addLine("-------------------------");
		addLineWithTitle("Total Consultations:", String.valueOf(totalConsultations));
		addLineWithTitle("Total Fee", String.format("$%.2f", totalFee));
		
		closeAndSave();
	}
}
