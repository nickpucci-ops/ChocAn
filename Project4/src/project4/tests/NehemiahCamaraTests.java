package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project4.Manager;
import project4.Member;
import project4.Operator;
import project4.Provider;
import project4.Terminal;

class NehemiahCamaraTests {

    Terminal terminal;
    
    @BeforeEach
    void setUp() {
        terminal = new Terminal();
    }
    
    @Test 
    void testGetStreetAddress() {
        Member newMember = new Member("John Mark", 509, "164 Elm Street", "Seattle", "WA", 13578);
        String streetAddress = newMember.getStreetAddress();
        assertEquals("164 Elm Street", streetAddress, "Street address should match the expected value.");
    }

    @Test 
    void testGetZipCode() {
        Member newMember = new Member("David Beck", 180, "119 Parkway Street", "Denver", "CO", 18465);
        int zipCode = newMember.getZipCode(); 
        assertEquals(18465, zipCode, "Zip code should match the expected value.");
    }
    
    void testUpdateAddress(){
        provider.updateAddress("456 New Street", "New City", "New State", 67890);
        
        
        assertEquals("456 New Street", provider.getStreetAddress(), "Street address should be updated.");
        assertEquals("New City", provider.getCity(), "City should be updated.");
        assertEquals("New State", provider.getState(), "State should be updated.");
        assertEquals(67890, provider.getZipCode(), "Zip code should be updated.");
    }
}
