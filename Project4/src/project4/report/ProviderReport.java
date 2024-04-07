package project4.report;

import project4.Provider;


public class ProviderReport extends Report{
	Provider provider;
	public ProviderReport(Provider provider, String filename) {
		super(filename, "Provider Report");
		addLineWithTitle("Provider Name:", "James Bald");
		addLineWithTitle("Provider Number:", String.format("%09d", 9));
		addLineWithTitle("Street Address:", "somewhere");
		addLineWithTitle("City:", "Boston");
		addLineWithTitle("State:", "MA");
		addLineWithTitle("Zip Code:", String.format("%05d", 5));
		
		addLine(""); // Add a blank line for spacing
        addLineWithTitle("Date of Service:", "01-10-2024");
        addLineWithTitle("Received on:", "01-10-2024, 10:29:38");
        addLineWithTitle("Member Name:", "Bob");
        addLineWithTitle("Member Number:", String.format("%09d", 9));
        addLineWithTitle("Service Code:", String.format("%06d", 6));
        addLineWithTitle("Fee to be Paid:", String.format("$%.2f", 3.0));
        addLineWithTitle("Total Consultations:", "3");
        addLineWithTitle("Total Fee for Week: ", String.format("$%.2f", 99999.0));
 	
		closeAndSave();
 
	}
}

/*  For each service provided, the following details are required:     
	Date of service (MM–DD–YYYY).     
	Date and time data were received by the computer (MM–DD–YYYY HH:MM:SS).     
	Member name (25 characters).     
	Member number (9 digits).     
	Service code (6 digits).     
	Fee to be paid (up to $999.99).    
	Total number of consultations with members (3 digits).    
	Total fee for week (up to $99,999.99). 
*/
