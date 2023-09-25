package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private final String name = "Bulka";
    private final float price = 100F;
    Bun bun = new Bun(name, price);
    @Test
    public void getName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}