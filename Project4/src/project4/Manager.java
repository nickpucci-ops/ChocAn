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
	public void getProviderReport(Terminal terminal, Provider provider) {
		ProviderReport providerReport = new ProviderReport(provider, "ProviderReport.pdf", terminal.getServicesForProvider(provider));
		providerReport.open();
	}
	
	public void getMemberReport(Terminal terminal, Member member) {
	ArrayList<Service> memberServices = terminal.getServicesForMember(member);
	MemberReport memberReport = new MemberReport(member, "MemberReport.pdf", memberServices);
	memberReport.open();
	}
	
	public void getSummaryReport(Terminal terminal) {
		SummaryReport summaryReport = new SummaryReport(terminal, "summary.pdf");
		summaryReport.open();
	}
}
