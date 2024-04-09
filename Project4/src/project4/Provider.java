package project4;
import project4.report.*;
import project4.Terminal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import project4.Service;

public class Provider extends Employee{
	private String name;
    private int providerNumber; 
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private ArrayList<Service> services;
	
	public Provider(int id, String username, String name, int providerNumber, String streetAddress, String city, String state, int zipCode) {
		super(Employee.PROVIDER, id, username);
		this.name = name;
        this.providerNumber = providerNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
	}
	
	public void getProviderDirectory(Terminal terminal) {
		ProviderDirectory PD = new ProviderDirectory("ProviderDirectory.pdf", terminal);
		PD.open();
	}
	
	public void createNewServiceRecord(Terminal terminal, String dateProvided, String providerID, String memberID, String serviceCode, String fee, String comments) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-DD-YYYY");
		Service service;
		try {
			service = new Service(terminal.getServiceCodes().get(serviceCode), Integer.parseInt(serviceCode), Float.parseFloat(fee),
					new SimpleDateFormat("MM-DD-YYYY").parse(dateProvided),
					Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()), terminal.getMemberByNumber(memberID), terminal.getProviderByNumber(providerID), comments);
			terminal.addService(service);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    public ArrayList<Service> getServices(Terminal terminal) {
    	ArrayList<Service> temp = new ArrayList<Service>();
    	for (Service service : terminal.getServices()) {
    		if (service.getProvider() == this) {
    			temp.add(service);
    		}
    	}
    	services = temp;
    	return services;
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