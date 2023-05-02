import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"булочка", 100f},
                {null, 100f},
                {"bulochka", 100f},
                {"булка", 0f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void nameBunTest() {
        String expectedName = name;
        String actualName = bun.getName();
        Assert.assertEquals("Название булочки некорректное", expectedName, actualName);
    }

    @Test
    public void priceBunTest() {
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Название булочки некорректное", expectedPrice, actualPrice,0);
    }

}
