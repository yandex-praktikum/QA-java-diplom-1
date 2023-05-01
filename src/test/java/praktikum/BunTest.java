package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private String name = "Tasty";
    private float price = (float) 2.11;

    @Test
    public void BunGetNameTest() {
        Bun bun = new Bun(name,price);
        assertEquals(name,bun.getName());
    }

    @Test
    public void BunGetPriceTest() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(price,bun.getPrice(), 0.0f);
    }
}
