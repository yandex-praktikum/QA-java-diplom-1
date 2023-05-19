package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Чизбургер",350.78f);
        assertEquals("Чизбургер", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Чизбургер",350.78f);
        assertEquals(350.78f, bun.getPrice(),0);
    }
}