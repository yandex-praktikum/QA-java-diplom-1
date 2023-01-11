package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Burger", 15);
        assertEquals("Burger", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Burger", 15);
        assertEquals(15, bun.getPrice(), 0);
    }
}