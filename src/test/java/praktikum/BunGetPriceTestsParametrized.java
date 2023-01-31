package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetPriceTestsParametrized {

    Bun bun;
    private float price;
    private float expectedPrice;

    public BunGetPriceTestsParametrized(float price, float expectedPrice) {
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "price : {0}, expectedPrice : {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {100, 100},
                {200, 200F},
                {300, 300},
                {0.1, 0.1},
                {0.1, 0.1F},
                {0.1F, 0.1F},
        };
    }


    @Before
    public void setUp() {
        bun = new Bun("Default name", price);
    }

    @Test
    public void testBunGetPrice() {

        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
