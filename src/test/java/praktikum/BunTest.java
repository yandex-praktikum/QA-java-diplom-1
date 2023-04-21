package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Black bun", 100);
        assertEquals("Black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Black bun", 100);
        assertEquals(100, bun.getPrice(), 0);
    }

}