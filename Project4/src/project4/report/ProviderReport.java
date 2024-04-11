package project4.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
		addLineWithTitle("Zip Code:", String.format("%05d", provider.getZipCode()));
		
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
	    DateFormat dateTimeFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss"); 
	    Calendar calobj = Calendar.getInstance(); 
	       
		addLine(""); // Add a blank line for spacing
		addLineWithTitle("Serivces:", "");
		for(Service service : services){
	        addLineWithTitle("Date of service:", df.format(service.getDateProvided()));
	        addLineWithTitle("Date recorded:", dateTimeFormat.format(service.getDateEntered()));
	        addLineWithTitle("Member Name:", "Bob");
	        addLineWithTitle("Member Number:", String.format("%09d", service.getMember().getMemberNumber()));
	        addLineWithTitle("Service Code:", String.format("%06d", service.getCode()));
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
