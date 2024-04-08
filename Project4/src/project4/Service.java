package project4;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Service  {
    private String name; 
    private int code;
    private int fee; 
    private Date dateProvided;
    private Date dateEntered;
    private Member member;
    private Provider provider;
    private String comments;

    public Service(String name, int code, int fee, Date dateProvided, Date dateEntered, Member member, Provider provider, String comments) {
        this.name = name;
        this.code = code;
        this.fee = fee;
        this.dateProvided = dateProvided;
        this.dateEntered = dateEntered;
        this.member = member;
        this.provider = provider;
        this.comments = comments;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Date getDate() {
    	return this.dateProvided;
    }
    
    public Provider getProvider() {
    	return this.provider;
    }
    
    public int getCode() {
    	return this.code;
    }

    public static Date setDate() {
        return new Date();
    }

    private boolean checkFormat(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return formatDate.format(date).equals(date.toString());
    }

    public void setDateProvided(Date dateProvided) { //date of service provided
        if (checkFormat(dateProvided)) {
            this.dateProvided = dateProvided;
        }
        else {
            throw new IllegalArgumentException("Date must be in the format MM/DD/YYYY");
        }
    }

    public void setDateEntered(Date dateEntered) { //date of information entered
        if (checkFormat(dateEntered)) {
            this.dateEntered = dateEntered;
        }
        else {
            throw new IllegalArgumentException("Date must be in the format MM/DD/YYYY");
        }
    }
    
    public int getFee() {
    	return this.fee;
    }
}
