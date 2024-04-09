package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project4.Manager;
import project4.Member;
import project4.Provider;
import project4.Service;
import project4.Terminal;
import project4.report.MemberReport;
import project4.report.ProviderReport;
import project4.report.SummaryReport;

import java.io.File;
import java.lang.reflect.Constructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

class KasandraVallesJunitTests {
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
    void setUp() {
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
    void testGetProviderReport() throws Exception {
      ProviderReport providerReport = null;
      Assertions.assertNull(providerReport);
    }

    @Test
    void testGetMemberReport() throws Exception {
    	MemberReport memberReport = null;
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
		Assertions.assertNotNull(memberReports.get(0));
 
    }

    @Test
    void testGetSummaryReport() throws Exception {
    	SummaryReport summaryReport = null;
    	Assertions.assertNull(summaryReport);
       
    }
}
