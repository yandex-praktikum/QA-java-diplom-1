package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunTestData() {
        return new Object[][]{
                {"Bun", 25.5f},
                {"", -10.1f},
                {null, 0.0f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
