package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void bunGetNameTest () {
        String expectedName = "Булка";
        float expectedPrice = 0;
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualBunGetName = bun.getName();
        Assert.assertEquals("getName() returned an invalid value", expectedName, actualBunGetName);
    }

    @Test
    public void bunGetPriceTest () {
        float expectedPrice = 100.0F;
        Bun bun = new Bun(null, expectedPrice);
        float actualBunGetPrice = bun.getPrice();
        Assert.assertEquals("getPrice() returned an invalid value", expectedPrice, actualBunGetPrice, 0);
    }
}
