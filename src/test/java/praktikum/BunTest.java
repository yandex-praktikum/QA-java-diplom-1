package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {
    Bun bun = new Bun("Apple", 2.50f);

    @Test
    public void getName() {
        String expectedName = "Apple";
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        float expectedPrice = 2.50f;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}