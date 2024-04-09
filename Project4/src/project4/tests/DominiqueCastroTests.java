package project4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import project4.*;

class DominiqueCastroTests {
	Terminal terminal;
	@BeforeEach
	void setUp() throws Exception {
		terminal = new Terminal();
	}
	
	@Test
	void testMatchingCardNum() {
		Card card = new Card("Billy Joe", 123);
		Member member = new Member("Billy Joe", 123, "123 Main Street", "Tuscaloosa", "AL", 35405);
		Assertions.assertEquals(card.getMemberNumber(), member.getMemberNumber());
	}
	
	@Test
	void testMatchingCardName() {
		Card card = new Card("John Doe",394 );
		Member member = new Member("John Doe", 394, "123 Main Street", "Tuscaloosa", "AL", 35405);
		Assertions.assertEquals(card.getMemberName(), member.getMemberName());
	}
	
	@Test
	void testService() {
		Card card = new Card("Billy Joe", 123);
		Service service = new Service("Consultation", 1, 100, new Date(), new Date(), new Member(), new Provider(), "Comments", card);
		Card serviceCard = service.getCard();
		Assertions.assertEquals(card.getMemberNumber(), serviceCard.getMemberNumber());
	}

}
