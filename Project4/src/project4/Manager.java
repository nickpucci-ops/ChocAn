package project4;

import project4.report.ProviderReport;
import project4.report.Report;

public class Manager extends Employee {
	Manager(int id, String username) {
		super(Employee.MANAGER, id, username);
	}
	
	public void getProviderReport(Provider provider) {
		ProviderReport pReport = new ProviderReport(provider,"Provider Report");
		pReport.open();
	}
	public void sendReport(Report report) {
		
	}
}
