package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Вкусная", 1150);
        assertEquals("Вкусная", bun.getName());

    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Вкусная", 1150);
        assertEquals(1150.0, bun.getPrice(), 0);
    }
}