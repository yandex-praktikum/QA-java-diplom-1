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
    private static final Bun firstBun = TestData.returnFirstBun();
    private static final Bun secondBun = TestData.returnSecondBun();
    private static final Bun thirdBun = TestData.returnThirdBun();

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {firstBun.getName(), firstBun.getPrice()},
                {secondBun.getName(), secondBun.getPrice()},
                {thirdBun.getName(), thirdBun.getPrice()},
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
        Assert.assertEquals("Prices should match", price, actualPrice, 0.0f);
    }
}
