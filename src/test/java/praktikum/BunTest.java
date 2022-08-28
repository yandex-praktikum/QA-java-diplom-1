package praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun;

    @Before
    public void startUp() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        assertEquals("Incorrect bun's name",expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        int expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        assertEquals("Incorrect bun's price",expectedPrice, actualPrice, 0);
    }
}
