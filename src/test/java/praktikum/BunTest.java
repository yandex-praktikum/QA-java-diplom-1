package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class BunTest {
    private Bun bun;

    @Before
    public void createNewBun() {
        bun = new Bun("red bun", 300);
    }

    @Test
    public void getBunNameTest() {
        String expected = "red bun";
        assertEquals(expected, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        float expected = 300;
        assertEquals(expected, bun.getPrice(), 0);
    }
}
