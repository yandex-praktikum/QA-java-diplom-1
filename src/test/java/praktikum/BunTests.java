package praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTests {

    Bun testBun;

    @Before
    public void setup() {
        testBun = new Bun("Ахмат бургер", 150.65f);
    }

    @Test
    public void testGetName() {
        String actualName = "Ахмат бургер";
        assertEquals(actualName, testBun.getName());
    }

    @Test
    public void testGetPrice() {
        float actualPrice = 150.65f;
        assertEquals(actualPrice, testBun.getPrice(), 0);
    }

}
