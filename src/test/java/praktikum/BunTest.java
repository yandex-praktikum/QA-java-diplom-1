package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    String name = "black bun";
    float price = 100;

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String expected = "black bun";
        assertEquals(expected, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        float expected = 100;
        assertEquals(expected, bun.getPrice(), 0);
    }
}