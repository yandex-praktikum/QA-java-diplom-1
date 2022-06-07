import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


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
    public static Object[][] setBun() {
        return new Object[][]{
                {"Tanya", 100},
                {null, 0},
                {"TestName", -1},
                {"", -0.1F}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName() {
        String actualName = bun.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void checkGetPrice() {
        float actualPrice = bun.getPrice();
        Assert.assertTrue(actualPrice == price);
    }
}
