package project4;

import project4.report.ProviderReport;
import project4.report.Report;

public class Manager extends Employee {
	Manager(int id, String username) {
		super(Employee.MANAGER, id, username);
	}
	
	public void getProviderReport(Provider provider) {
<<<<<<< HEAD
		ProviderReport pReport = new ProviderReport(provider,"Provider Report");
		pReport.open();
=======
		ProviderReport preport = new ProviderReport( provider ,"Provider Report" );
>>>>>>> branch 'main' of https://bitbucket.org/azaman2/spring24team6/src/main/
	}
	public void sendReport(Report report) {
		
	}
}
