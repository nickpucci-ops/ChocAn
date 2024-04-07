package project4.report;

public class ProviderDirectory extends Report {
	public ProviderDirectory(String filename) {
		super(filename, "Provider Directory");
		addLineWithTitle("598470", "Dietitian");
		addLineWithTitle("883948", "Aerobic Exercise");
		addLineWithTitle("123456", "Chocoholic Counseling");
		addLineWithTitle("255034", "Consultation");
		closeAndSave();
	}
}