import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"T", 1},
                {null, 0},
                {"TestName", -1},
                {"", -0.1F}
        };
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();
        Assert.assertTrue(actualPrice == price);
    }
}
