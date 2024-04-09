package project4.report;

import java.util.ArrayList;

import project4.Member;
import project4.Service;

public class MemberReport extends Report {
	Member member;
	public MemberReport(Member member, String filename, ArrayList<Service> services) {
		super(filename, "Member Report");
		addLineWithTitle("Member Name:", member.getName());
		addLineWithTitle("Member Number:", String.format("%09d", member.getMemberNumber()));
		addLineWithTitle("Street Address:", member.getStreetAddress());
		addLineWithTitle("City:", member.getCity());
		addLineWithTitle("State:", member.getState());
		addLineWithTitle("Zip Code:", String.format("%05d",member.getZipCode()));
		addLine("");
		addLineWithTitle("Services:", "");
		for(Service service : services){
			addLineWithTitle("Service Code: ", String.format("%06d", service.getCode()));
			addLineWithTitle("Provider: ", service.getProvider().getName());
			addLineWithTitle("Date: ", service.getDate().toString());
			addLine("");
		}
		
		closeAndSave();
	}
}
