package project4.report;

import java.util.Map.Entry;

import project4.Terminal;

public class ProviderDirectory extends Report {
	public ProviderDirectory(String filename, Terminal terminal) {
		super(filename, "Provider Directory");
		for(Entry<Integer, String> e : terminal.getServiceCodes().entrySet()) {
			addLineWithTitle(String.valueOf(e.getKey()), e.getValue());
		}
		
		closeAndSave();
	}
}