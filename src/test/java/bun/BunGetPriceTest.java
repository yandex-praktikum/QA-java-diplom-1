package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunGetPriceTest {

    String name = "name";
    private final float price;

    public BunGetPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOfBun() {
        return new Object[][]{
                {100},
                {-100},
                {0},
        };
    }

    @Test
    public void getNPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
