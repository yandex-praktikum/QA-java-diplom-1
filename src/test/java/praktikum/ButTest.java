package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ButTest {
    private final String name = "Bun with sesame seeds";
    private final float price = 10F;

    @Test
    public void getNameReturnBunName() {
        Bun bun = new Bun(name, price);
        String actualResult = bun.getName();

        assertEquals(name, actualResult);
    }

    @Test
    public void getPriceReturnBunPrice() {
        Bun bun = new Bun(name, price);
        float actualResult = bun.getPrice();

        assertEquals(price, actualResult, 0.00001);
    }
}
