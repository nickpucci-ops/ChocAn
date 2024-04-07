package project4;
import project4.report.*;
import java.awt.*;

public class Provider extends Employee{
	public Provider(int id, String username) {
		super(Employee.PROVIDER, id, username);
	}
	
	public void getProviderDirectory() {
		ProviderDirectory PD = new ProviderDirectory("providerDirectory.pdf");
		PD.open();
	}
}