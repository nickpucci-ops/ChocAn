package project4.report;

import java.util.ArrayList;

import project4.Provider;
import project4.Service;

public class ProviderReport extends Report{
	Provider provider;
	public ProviderReport(Provider provider, String filename, ArrayList<Service> services) {
		super(filename, "Provider Report");
		int totalConsultations = 0;
		float totalFee = 0;
		
		addLineWithTitle("Provider Name:", provider.getName());
		addLineWithTitle("Provider Number:", String.format("%09d", provider.getProviderNumber()));
		addLineWithTitle("Street Address:", provider.getStreetAddress());
		addLineWithTitle("City:", provider.getCity());
		addLineWithTitle("State:", provider.getState());
		addLineWithTitle("Zip Code:", String.format("%05d", 5));
		
		addLine(""); // Add a blank line for spacing
		for(Service service : services){
			addLineWithTitle("Date of Service:", "");
	        addLineWithTitle("Received on:", "01-10-2024, 10:29:38");
	        addLineWithTitle("Member Name:", "Bob");
	        addLineWithTitle("Member Number:", String.format("%09d", 9));
	        addLineWithTitle("Service Code:", String.format("%06d", 6));
	        addLineWithTitle("Fee to be Paid:", String.format("$%.2f", service.getFee()));
			totalConsultations++;
			totalFee += service.getFee();
			addLine("");
		}
        addLineWithTitle("Total Consultations:", String.format("%d", totalConsultations));
        addLineWithTitle("Total Fee for Week: ", String.format("$%.2f", totalFee));
 	
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
