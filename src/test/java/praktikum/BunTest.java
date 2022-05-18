package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Ржаная", 5);
        String expectedName = "Ржаная";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Ржаная", 5);
        float expectedPrice = 5;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}