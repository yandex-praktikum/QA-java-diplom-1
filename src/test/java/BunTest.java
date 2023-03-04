import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetNameReturnName() {
        String name = "Булка";
        float price = 12.3F;
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPriceReturnPrice() {
        String name = "Булка";
        float price = 12.3F;
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}