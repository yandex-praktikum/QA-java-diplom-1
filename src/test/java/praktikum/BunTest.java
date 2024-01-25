package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Bun name", 500);

    @Test
    public void getBunNameTest() {
        assertEquals("Bun name", bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals(500, bun.getPrice(), 0.0f);
    }
}