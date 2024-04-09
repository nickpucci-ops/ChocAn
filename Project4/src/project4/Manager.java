package project4;
/**
 * My manager class description
 * 
 * @author KasandraValles
 * @version 1.0
 */

import java.util.ArrayList;
import java.time.format.*;
import java.time.LocalDateTime;

import project4.report.MemberReport;
import project4.report.ProviderReport;
import project4.report.Report;
import project4.report.SummaryReport;

/**
 * The Manager class represents a manager within the system.
 * Managers have the ability to generate reports for providers, members, and summary of services.
 */
public class Manager extends Employee {
    
    /**
     * Constructs a new Manager object with the given ID and username.
     * 
     * @param id The ID of the manager.
     * @param username The username of the manager.
     */
    Manager(int id, String username) {
        super(Employee.MANAGER, id, username);
    }

    /**
     * Generates a report for a specific provider.
     * 
     * @param terminal The terminal through which the report is generated.
     * @param provider The provider for whom the report is generated.
     */
    public void getProviderReport(Terminal terminal, Provider provider) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
        ProviderReport providerReport = new ProviderReport(provider, provider.getName() + " - " + formatter.format(LocalDateTime.now()) + ".pdf", terminal.getServicesForProvider(provider));
        providerReport.open();
    }
    
    /**
     * Generates a report for a specific member.
     * 
     * @param terminal The terminal through which the report is generated.
     * @param member The member for whom the report is generated.
     */
    public void getMemberReport(Terminal terminal, Member member) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
        ArrayList<Service> memberServices = terminal.getServicesForMember(member);
        MemberReport memberReport = new MemberReport(member, member.getName() + " - " + formatter.format(LocalDateTime.now()) + ".pdf", memberServices);
        memberReport.open();
    }
    
    /**
     * Generates a summary report of services.
     * 
     * @param terminal The terminal through which the report is generated.
     */
    public void getSummaryReport(Terminal terminal) {
        SummaryReport summaryReport = new SummaryReport(terminal, "summary.pdf");
        summaryReport.open();
    }
}
