package tests;

import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;
    private final float delta = TestData.DELTA;
    private static final Bun FIRST_BUN = TestData.returnBunByIndex(0);
    private static final Bun SECOND_BUN = TestData.returnBunByIndex(1);
    private static final Bun THIRD_BUN = TestData.returnBunByIndex(2);

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunsData() {
        return new Object[][]{
                {FIRST_BUN.getName(), FIRST_BUN.getPrice()},
                {SECOND_BUN.getName(), SECOND_BUN.getPrice()},
                {THIRD_BUN.getName(), THIRD_BUN.getPrice()},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals("Names should match", name, actualName);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Prices should match", price, actualPrice, delta);
    }
}
