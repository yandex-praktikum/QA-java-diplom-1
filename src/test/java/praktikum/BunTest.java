package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void bunShouldHasName() {
        Bun bun = new Bun("newBun", 1000);
        assertEquals("newBun", bun.getName());
    }

    @Test
    public void bunShouldHasPrice() {
        Bun bun = new Bun("newBun", 1000);
        assertEquals(1000, bun.getPrice(),0.001f);
    }
}