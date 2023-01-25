package praktikum;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)

public class BunTest {
    private final float bunPrice;
    private final String bunName;

    public BunTest(float bunPrice, String bunName) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {100, "black bun"},
                {1000, "white bun"},
                {300, "red bun"},
                {3000, ""},
                {400, "black bun bun bun"},
                {4000, null},
                {500, "!@#$%^&*()_+"},
                {5000, "крестьянский"},
                {600, " red bun "},
                {6000, "Red bun"},
                {70000000, "redbun"},
                {-100, "red bun"},
                {0, "red bun"},
                {1.2e-20f, "red bun"},
        };
    }

    @Test
    public void getPriceReturnRightValue() {
        Bun bun = new Bun(bunName, bunPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("price is correct", bunPrice, actualPrice, 0.0);
    }

    @Test
    public void getNameReturnRightBun() {
        Bun bun = new Bun(bunName, bunPrice);
        String actualName = bun.getName();
        Assert.assertEquals("name is correct", bunName, actualName);
    }
}