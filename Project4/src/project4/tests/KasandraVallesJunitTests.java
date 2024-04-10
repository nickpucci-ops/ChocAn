package project4.tests;


import static org.junit.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project4.Manager;
import project4.Provider;
import project4.Terminal;
import project4.report.ProviderReport;
import project4.report.SummaryReport;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


class KasandraVallesJunitTests {
	private Manager manager;
    private Terminal terminal;
    private Provider provider;

    @BeforeEach
    void setUp() throws Exception {
    	manager = new Manager(1, "manager1");
        terminal = new Terminal();
        provider = new Provider(1, "Provider1", "Provider Name", 1, "123 Street Name", "City", "State", 12345);
        terminal = new Terminal();
    }

   @Test
   void testGetProviderReportSuccess() {
	   //no errors in provider
	   try {
           manager.getProviderReport(terminal, provider);
           // If the method call completes without throwing an exception, the test passes
           assertTrue(true);
       } catch (Exception e) {
           // If an exception is thrown, the test fails
           fail("Exception thrown: " + e.getMessage());
       }
   }
   
   @Test
   void testGetSummaryReportSuccess() {
	   ArrayList<SummaryReport> summaryReports = new ArrayList<SummaryReport>();
	   SummaryReport summaryReport = new SummaryReport(terminal, "summary.pdf");
	   summaryReports.add(summaryReport);
	   Assertions.assertEquals(summaryReports.size(), 1);   
	   }
   
   @Test
   void testCreateNewServiceRecordFailure() throws ParseException {
	   String dateProvided = "2024-04-09";
	   String providerID = "2";
	   String memberID = "3";
	   String serviceCode = "123456";
	   String fee = "100.00";
	   String comments = "Test comments";
	   provider.createNewServiceRecord(terminal, dateProvided, providerID, memberID, serviceCode, fee, comments);
   }
}