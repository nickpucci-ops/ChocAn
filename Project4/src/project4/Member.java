package project4;

public class Member extends Employee {
    private String name;
    private int memberNumber; 
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String status; 

    public Member(String name, int memberNumber, String streetAddress, String city, String state, int zipCode) {
        this.name = name;
        this.memberNumber = memberNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = "active"; 
    }

   
    public void updateAddress(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

//    public void displayMemberInfo() {
//        System.out.println("Member Name: " + this.name);
//        System.out.println("Member Number: " + this.memberNumber);
//        System.out.println("Address: " + this.streetAddress + ", " + this.city + ", " + this.state + ", " + this.zipCode);
//        System.out.println("Status: " + this.status);
//    }

    
    public String getName() {
        return name;
    }

    public int getMemberNumber() {
        return memberNumber;
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

    public String getStatus() {
        return status;
    }

    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
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

    public void setStatus(String status) {
        this.status = status;
    }
}
