package project4.report;

import project4.*;

public class SummaryReport extends Report {
	public SummaryReport(Terminal terminal, String filename) {
		super(filename, "Summary Report");
		int totalFee = 0;
		int totalConsultations = 0;
		for(Employee employee : terminal.getEmployees()) {
			if(employee.getEmployeeType() == Employee.PROVIDER) {
				addLineWithTitle("Provider: ", employee.getUsername());
				int numConsultations = 0;
				int totalProviderFee = 0;
				for(Service service : terminal.getServices()) {
					numConsultations++;
					totalProviderFee += service.getFee();
				}
				addLineWithTitle("Number of Consultations:", String.valueOf(numConsultations));
				addLineWithTitle("Fee: ", String.valueOf(totalProviderFee));
				totalFee += totalProviderFee;
				totalConsultations += numConsultations;
			}
		}
		addLine("-------------------------");
		addLineWithTitle("Total Consultations:", String.valueOf(totalConsultations));
		addLineWithTitle("Total Fee", String.valueOf(totalFee));
		
		closeAndSave();
	}
}
