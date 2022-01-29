package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getNameBunReturnName() {
        Bun bun = new Bun("black bun", 100);

        String expectedName = "black bun";
        String actualName = bun.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceBunReturnPrice() {
        Bun bun = new Bun("black bun", 100);

        float expectedPrice = 100;
        float actualPrice = bun.getPrice();

       Assert.assertEquals(actualPrice, expectedPrice, 0);
    }
}
