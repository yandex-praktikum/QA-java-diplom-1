package praktikumtests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {

    private String name;
    private float price;
    private Bun bun;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][]{
                {null, 100},
                {"", 100},
                {"red bun", 10.5f},
                {"white bun", 200},
                {"red bun", 0},
                {"red bun", 0.0f},
                {"red bun", -100}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void nameTest() {
        Assert.assertTrue("bun name can't be null, or empty",
                bun.getName() != null && bun.getName() != "" && name.equals(bun.getName()));
    }

    @Test
    public void priceTest() {
        Assert.assertTrue("bun price must be > 0",
                bun.getPrice() > 0 && bun.getPrice() == price);


    }

}




