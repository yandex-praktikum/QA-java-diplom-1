package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private final String name = "Space bun";
    private final float price = 50F;

    @Test
    public void getNameReturnsBunName() {
        Bun bun = new Bun(name, price);
        String actualResult = bun.getName();

        assertEquals("The name is not 'Space bun'", name, actualResult);
    }

    @Test
    public void getPriceReturnsBunPrice() {
        Bun bun = new Bun(name, price);
        float actualResult = bun.getPrice();

        assertEquals(price, actualResult, 0.00001);
    }
}