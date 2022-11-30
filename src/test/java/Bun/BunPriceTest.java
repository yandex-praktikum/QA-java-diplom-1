package Bun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {

    private final float priceBun;
    private final float expected;
    private final float DELTA = 0.001f;

    public BunPriceTest(float price, float expected) {
        this.priceBun = price;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] priceParam() {
        return new Object[][] {
                {0.1f, 0.1f},
                {1.99f, 1.99f},
                {11, 11}
        };
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun ("first", priceBun);
        float actual = bun.getPrice();
        assertEquals("Данные не совпадают", expected, actual, DELTA);

    }
}
