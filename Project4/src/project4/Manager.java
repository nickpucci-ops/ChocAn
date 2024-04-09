package project4;

import java.util.ArrayList;

import project4.report.MemberReport;
import project4.report.ProviderReport;
import project4.report.Report;
import project4.report.SummaryReport;

public class Manager extends Employee {
	Manager(int id, String username) {
		super(Employee.MANAGER, id, username);
	}
	public void getProviderReport(Provider provider) {
		ProviderReport pReport = new ProviderReport( provider ,"Provider Report" );
		pReport.open();
	}
	
	public void getMemberReport(Terminal terminal, Member member) {
	ArrayList<Service> memberServices = terminal.getServicesForMember(member);
	MemberReport memberReport = new MemberReport(member, "MemberReport.pdf", memberServices);
	memberReport.open();
	}
	
	public void getSummaryReport() {
		//ask
	}
	public void sendReport(Report report) {
		//TODO 
	}
}
