package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final static float ZERODELTABUNPRICE = 0;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters(name = "Test: {0} | {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"black bun", 100},
                {"test name bun", Float.MIN_VALUE},
                {"", Float.MAX_VALUE},
                {null, 0},
                {" % ", -100.5F}
        };
    }


    @Test
    public void checkGetBunName() {
        Bun bun = new Bun(name, price);
        assertEquals("Bun name is incorrect", name, bun.getName());
    }

    @Test
    public void checkGetBunPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Bun price is incorrect", price, bun.getPrice(), ZERODELTABUNPRICE);
    }
}