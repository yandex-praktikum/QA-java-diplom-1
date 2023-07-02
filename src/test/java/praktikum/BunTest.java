package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testTestGetName() {
        String expected = "name";
        Bun bun = new Bun(expected, 11);
        assertEquals(expected, bun.getName());
    }

    @Test
    public void testGetPrice() {
        float expected = 11;
        Bun bun = new Bun("name", expected);
        assertEquals(expected, bun.getPrice(), 0.0);
    }
}