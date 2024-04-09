package project4;

/**
 * This class provides diffent attributes to each member
 * it gives them a name, number, address, and member status 
 * @author Nehemiah Camara
 *
 */


public class Member {
    private String name;
    private int memberNumber; 
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String status; 
 
    
    /**
     *  Constructor for the class
     * @param name used to set name variable for this class
     * @param memberNumber used to assign number to this variable
     * @param streetAddress used to assign to this variable
     * @param city used to assign to this variable
     * @param state used to assign to this variable 
     * @param zipCode used to assign to this variable
     */
    public Member(String name, int memberNumber, String streetAddress, String city, String state, int zipCode) {
        this.name = name;
        this.memberNumber = memberNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = "active";
    }

   
    /**
     * this class updates the below variables to new values
     * @param streetAddress updates the street address with this parameter
     * @param city updates the city with this parameter
     * @param state updates the state with this parameter
     * @param zipCode updates the zipCode with this parameter
     */
    
    public void updateAddress(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    
    /**
     * this class updates the status variable to a new value
     * @param status updates the status with this parameter
     * 
     */
    public void changeStatus(String status) {
        this.status = status;
    }

//    public void displayMemberInfo() {
//        System.out.println("Member Name: " + this.name);
//        System.out.println("Member Number: " + this.memberNumber);
//        System.out.println("Address: " + this.streetAddress + ", " + this.city + ", " + this.state + ", " + this.zipCode);
//        System.out.println("Status: " + this.status);
//    }

    /**
     * This function returns the name variable
     * @return name the name variable is returned from this function
     */
    public String getName() {
        return name;
    }
    /**
     * This function returns the memberNumber variable
     * @return memberNumber the memberNumber variable is returned from this function
     */
    public int getMemberNumber() {
        return memberNumber;
    }
    /**
     * This function returns the streetAddress variable
     * @return streetAddress the streetAddress variable is returned from this function
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    /**
     * This function returns the city variable
     * @return city the city variable is returned from this function
     */
    public String getCity() {
        return city;
    }
    /**
     * This function returns the state variable
     * @return state the state variable is returned from this function
     */
    public String getState() {
        return state;
    }
    /**
     * This function returns the zipCode variable
     * @return zipCode the zipCode variable is returned from this function
     */
    public int getZipCode() {
        return zipCode;
    }
    /**
     * This function returns the status variable
     * @return status the status variable is returned from this function
     */
    public String getStatus() {
        return status;
    }

    
    // Setters
    /**
     * This function updates the name variable in this class
     * @param name the new name to update this class's variable to
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This function updates the memberNumber variable in this class
     * @param memberNumber the new memberNumber to update this class's variable to
     */
    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }
    /**
     * This function updates the streetAddress variable in this class
     * @param streetAddress the new streetAddress to update this class's variable to
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    /**
     * This function updates the city variable in this class
     * @param city the new city to update this class's variable to
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * This function updates the state variable in this class
     * @param state the new state to update this class's variable to
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * This function updates the zipCode variable in this class
     * @param zipCode the new zipCode to update this class's variable to
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    /**
     * This function updates the status variable in this class
     * @param status the new status to update this class's variable to
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
