package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnTrueName() {
        String name = "С кунжутом";
        Bun bun = new Bun(name, 51.99f);
        String result = bun.getName();
        assertEquals(name, result);
    }

    @Test
    public void getPriceReturnTruePrice() {
        float price = 51.99f;
        Bun bun = new Bun("С кунжутом", price);
        float result = bun.getPrice();
        assertEquals(price, result, 0);
    }
}