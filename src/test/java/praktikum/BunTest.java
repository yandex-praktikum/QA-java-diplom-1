package praktikum;

import org.junit.*;
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
    public static Object[] getData() {
        return new Object[][]{
                {"normal bun", 100},
                {"hot bun", 200},
                {"energy bun", 300}
        };
    }

    @Before
    public void bulk() {
        this.bun = new Bun(name, price);
    }

    @Test
    public void getBunPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.0);
    }

    @Test
    public void getBunNameTest() {
        Assert.assertEquals(name, bun.getName());
    }

}
