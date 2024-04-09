/**
 * Service class is a class that represents a service provided by a member through the provider. It uses many parameters to get the information about the member, provider, and the service.
 * @author Dominique Castro
 */

package project4;

import java.util.Date;
/*
 * This constructor method for the Service class. It defines how a service object should be made.
 */
import java.text.SimpleDateFormat;

public class Service  {
    private String name; 
    private int code;
    private float fee; 
    private Date dateProvided;
    private Date dateEntered;
    private Member member;
    private Provider provider;
    private String comments;

    /*
     * This constructor method for the Service class. It defines how a service object should be made.
     * @param name is the name of the service
     * @param code is the code of the service
     * @param fee is the fee of the service
     * @param dateProvided is the date of when the service was provided
     * @param dateEntered is the date of when the information was entered
     * @param member is the member receiving the services
     * @param provider is the provider giving the services
     * @param comments are any comments from the provider
     */
    
    public Service(String name, int code, float fee, Date dateProvided, Date dateEntered, Member member, Provider provider, String comments) {
        this.name = name;
        this.code = code;
        this.fee = fee;
        this.dateProvided = dateProvided;
        this.dateEntered = dateEntered;
        this.member = member;
        this.provider = provider;
        this.comments = comments;
    }
    /*
     * Gets the name of the service for the instance
     */
    public String getName() {
    	return this.name;
    }
    /*
     *  Gets the date of when the service was provided for the instance
     */
    public Date getDateProvided() {
    	return this.dateProvided;
    }
    /*
     *  Gets the date of when the information was entered for the instance
     */
    public Date getDateEntered() {
    	return this.dateEntered;
    }
    /*
     * Gets the name of the provider for the instance
     */
    public Provider getProvider() {
    	return this.provider;
    }
    /*
     * Gets the name of the member for the instance
     */
    public Member getMember() {
    	return this.member;
    }
    /*
     * Gets the service code for the instance
     */
    public int getCode() {
    	return this.code;
    }
    /*
     * Checks if the format of the date is correct
     */
    private boolean checkFormat(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return formatDate.format(date).equals(date.toString());
    }
    /*
     * Gets the date if the date is in the correct format
     */
    public void setDateProvided(Date dateProvided) { //date of service provided
        if (checkFormat(dateProvided)) {
            this.dateProvided = dateProvided;
        }
        else {
            throw new IllegalArgumentException("Date must be in the format MM/DD/YYYY");
        }
    }
    /*
     * Gets the date if the date is in the correct format
     */
    public void setDateEntered(Date dateEntered) { //date of information entered
        if (checkFormat(dateEntered)) {
            this.dateEntered = dateEntered;
        }
        else {
            throw new IllegalArgumentException("Date must be in the format MM/DD/YYYY");
        }
    }
    /*
     * Gets the fee
     */
    public float getFee() {
    	return this.fee;
    }
    /*
     * Gets the comments
     */
    public String getComments() {
    	return comments;
    }
}
