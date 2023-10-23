package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {
    Bun bun = new Bun("Apple", 2.50f);

    @Test
    public void getName() {
        assertEquals("Apple", bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(2.50f, bun.getPrice(), 0);
    }
}