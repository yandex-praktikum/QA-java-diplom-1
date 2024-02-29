package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void beforeBenTest() {
        bun = new Bun(name, price);
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getNameAndPrice() {
        return new Object[][] {
                {"BigBurger", (float) 100},
                {"123456", (float) 150.00},
                {null, (float) 0},
                {"Burger", (float) -25.00}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Name of bun is not correct", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Price of bun is not correct", price, bun.getPrice(), DELTA);
    }
}