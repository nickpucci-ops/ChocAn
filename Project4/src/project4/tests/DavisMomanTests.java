package project4.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project4.*;
import project4.report.MemberReport;
import project4.report.ProviderReport;

class DavisMomanTests {

	Terminal terminal;
	ArrayList<Provider> sampleProviders;
	ArrayList<Member> sampleMembers;
	ArrayList<Service> sampleServices;
	
	Provider sampleProvider1;
	Provider sampleProvider2;
	Member sampleMember1;
	Member sampleMember2;
	Service sampleService1;
	Service sampleService2;
	Date today;
	
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
		sampleProviders = new ArrayList<Provider>();
		sampleMembers = new ArrayList<Member>();
		sampleServices = new ArrayList<Service>();
		sampleProvider1 = new Provider(1, "Username", "Jeremy Smith", 1, "Street St", "Tuscaloosa", "AL", 12345);
		sampleProvider2 = new Provider(2, "OtherUser", "Michael Scott", 2, "Office", "Scranton", "NY", 67890);
		sampleMember1 = new Member("Chocolate Lover", 1, "Cocoa Lane", "Tuscaloosa", "AL", 20204);
		sampleMember2 = new Member("Mr. Man", 2, "123 Lane", "Pigeon Forge", "TN", 32546);
		sampleProviders.add(sampleProvider1);
		sampleProviders.add(sampleProvider2);
		sampleMembers.add(sampleMember1);
		sampleMembers.add(sampleMember2);
		today = new Date();
		sampleService1 = new Service("Chocolate Counseling", 123456, (float)12.34, today, today, sampleMember1, sampleProvider1, "Comments");
		sampleService2 = new Service("Workout Session", 567890, (float)12.34, today, today, sampleMember2, sampleProvider2, "More Comments");
		sampleServices.add(sampleService1);
		sampleServices.add(sampleService2);
	}

	@Test
	void testMemberReportCreation() {
		ArrayList<MemberReport> memberReports = new ArrayList<MemberReport>();
		ArrayList<Service> tempServices = new ArrayList<Service>();
		for(Member member : sampleMembers) {
			for(Service tempService : sampleServices) {
				if(tempService.getMember() == member) {
					tempServices.add(tempService);
				}
			}
			MemberReport newReport = new MemberReport(member, "Member_Report-" + member.getMemberNumber() + ".pdf", tempServices);
			memberReports.add(newReport);
			tempServices.clear();
		}
		Assertions.assertEquals(memberReports.size(), 2);
		Assertions.assertNotNull(memberReports.get(0));
		Assertions.assertNotNull(memberReports.get(1));
	}
	
	@Test
	void testProviderReportCreation() {
		ArrayList<ProviderReport> providerReports = new ArrayList<ProviderReport>();
		ArrayList<Service> tempServices = new ArrayList<Service>();
		for(Provider provider : sampleProviders) {
			for(Service tempService : sampleServices) {
				if(tempService.getProvider() == provider) {
					tempServices.add(tempService);
				}
			}
			ProviderReport newReport = new ProviderReport(provider, "Provider_Report-" + provider.getId() + ".pdf", tempServices);
			providerReports.add(newReport);
			tempServices.clear();
		}
		Assertions.assertEquals(providerReports.size(), 2);
		Assertions.assertNotNull(providerReports.get(0));
		Assertions.assertNotNull(providerReports.get(1));
	}
	
	@Test
	void testTerminalFunctions() {
		Assertions.assertEquals(terminal.getMemberByName("Joe Schmoe"), terminal.getMembers().get(0));
		Assertions.assertEquals(terminal.getProviderByNumber("3"), terminal.getProviders().get(0));
		Assertions.assertNull(terminal.getProviderByName("Nonexistant Person"));
	}
}
