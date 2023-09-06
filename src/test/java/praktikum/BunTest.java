package praktikum;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.junit.Assert;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun with name {0} has a price {1}")
    public static Object data() {
        return new Object[][] {
                { "", 0.5f },
                { "", -1 },
                {"", 1},
                {"Bun", 0},
                {"Bun", -1.5f},
                {"Bun", 1}
        };
    }

    @org.junit.Test
    public void getNameCorrespondParametrization() {
        Bun bun = new Bun(name, price);
        String actualBunName = bun.getName();
        Assert.assertEquals(name, actualBunName);

    }

    @org.junit.Test
    public void getPriceCorrespondParametrizaton() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0.001f);
    }
}