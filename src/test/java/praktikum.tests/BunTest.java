package praktikum.tests;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("red bun", 300);
        String expectedName = "red bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("red bun", 300);
        float expectedPrice = 300;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 300);
    }
}