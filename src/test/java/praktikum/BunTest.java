package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("name", 100);
        String expected = "name";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("name", 100);
        float priceExpected = 100;
        float priceActual = bun.getPrice();
        assertEquals(priceExpected, priceActual, 0);
    }
}