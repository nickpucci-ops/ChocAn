package project4;
import project4.report.*;

public class Provider extends Employee{
	public Provider(int id, String username) {
		super(Employee.PROVIDER, id, username);
	}
	
	public void getProviderDirectory() {
		ProviderDirectory PD = new ProviderDirectory("ProviderDirectory.pdf");
		PD.open();
	}
}