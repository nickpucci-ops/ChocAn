package project4;
import project4.report.*;

public class Provider extends Employee{
	private String name;
    private int providerNumber; 
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
	
	public Provider(int id, String username, String name, int providerNumber, String streetAddress, String city, String state, int zipCode) {
		super(Employee.PROVIDER, id, username);
		this.name = name;
        this.providerNumber = providerNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
	}
	
	public void getProviderDirectory() {
		ProviderDirectory PD = new ProviderDirectory("ProviderDirectory.pdf");
		PD.open();
	}
	
    public void updateAddress(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public String getName() {
        return name;
    }

    public int getProviderNumber() {
        return providerNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setProviderNumber(int providerNumber) {
        this.providerNumber = providerNumber;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}