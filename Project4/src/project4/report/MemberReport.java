package project4.report;

import project4.Member;

public class MemberReport extends Report {
	Member member;
	public MemberReport(Member member, String filename) {
		super(filename, "Member Report");
		addLineWithTitle("Member Name:", member.getName());
		addLineWithTitle("Member Number:", String.valueOf(member.getMemberNumber()));
		addLineWithTitle("Street Address:", member.getStreetAddress());
		addLineWithTitle("City:", member.getCity());
		addLineWithTitle("State:", member.getState());
		addLineWithTitle("Zip Code:", String.valueOf(member.getZipCode()));
		
		closeAndSave();
	}
}
