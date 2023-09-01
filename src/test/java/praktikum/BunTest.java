package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;


public class BunTest {

    @Test
    public void testName() {
        Bun bun = new Bun("Bun1", 1.0f);
        assertEquals("Bun1", bun.getName());
    }

    @Test
    public void testPrice() {
        Bun bun = new Bun("Bun2", 2.0f);
        assertEquals(2.0f, bun.getPrice(), 0.01);
    }
}