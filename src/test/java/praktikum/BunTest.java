package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        float expected = 100;
        assertEquals(expected, actual, 0);
    }
} 