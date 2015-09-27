package Assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ cardTest.class, deckTest.class, GameTest.class, HandTest.class })
public class AllTests {

}
