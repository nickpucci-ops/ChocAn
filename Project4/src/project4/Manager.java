package project4;

import java.util.ArrayList;
import java.time.format.*;
import java.time.LocalDateTime;

import project4.report.MemberReport;
import project4.report.ProviderReport;
import project4.report.Report;
import project4.report.SummaryReport;

public class Manager extends Employee {
	Manager(int id, String username) {
		super(Employee.MANAGER, id, username);
	}
	public void getProviderReport(Terminal terminal, Provider provider) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
		ProviderReport providerReport = new ProviderReport(provider, provider.getName() + " - " + formatter.format(LocalDateTime.now()) + ".pdf", terminal.getServicesForProvider(provider));
		providerReport.open();
	}
	
	public void getMemberReport(Terminal terminal, Member member) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
		ArrayList<Service> memberServices = terminal.getServicesForMember(member);
		MemberReport memberReport = new MemberReport(member, member.getName() + " - " + formatter.format(LocalDateTime.now()) + ".pdf", memberServices);
		memberReport.open();
	}
	
	public void getSummaryReport(Terminal terminal) {
		SummaryReport summaryReport = new SummaryReport(terminal, "summary.pdf");
		summaryReport.open();
	}
}
