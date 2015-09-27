package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class cardTest {

	@Test
	public void test() {
		Card C = new Card(0,1);
		assertEquals("AceHearts", C.toString());
		assertEquals(1, C.getRank());
	}

}
