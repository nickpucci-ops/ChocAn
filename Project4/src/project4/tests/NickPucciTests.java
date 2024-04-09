package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project4.Member;
import project4.Provider;
import project4.Terminal;

class NickPucciTests {
	Terminal terminal;
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
	}

	@Test
	void testGetMemberNumber() {
		Member newMember = new Member("test member", 509, "123 Main Street", "Tuscaloosa", "AL", 45567);
		int num = newMember.getMemberNumber();
		
		Assertions.assertTrue(num == 509);
	}
	@Test
	void testGetProviderNumber() {
		Provider newProvider = new Provider(9, "provider1", "testJohn", 9, "testaddressd", "testcity", "al", 12345);
		int num = newProvider.getProviderNumber();
		
		Assertions.assertTrue(num == 9);
	}
	@Test
	void testGetCity() {
		Provider newProvider = new Provider(9, "provider1", "testJohn", 9, "testaddressd", "testcity", "al", 12345);
		String testcity = newProvider.getCity();
		
		Assertions.assertTrue(testcity == "testcity");
	}
}
