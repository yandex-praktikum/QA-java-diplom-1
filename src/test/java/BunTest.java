import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testConstructor() {
        Bun bun = new Bun("Plain Bun", 1.50f);
        assertEquals("Plain Bun", bun.getName());
        assertEquals(1.50f, bun.getPrice(), 0.01f); // Delta is set to handle floating-point comparison
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame Bun", 2.00f);
        assertEquals("Sesame Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Whole Wheat Bun", 1.75f);
        assertEquals(1.75f, bun.getPrice(), 0.01f);
    }
}
