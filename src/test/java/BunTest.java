import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Космическая булка", 0.01f},
                {"Булка с Меркурия", 34.05f},
                {"Булочка с изюмом", 87.90f}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }

    @Test
    public void createBunTest() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.name);
        Assert.assertEquals(bunPrice, bun.price, 0.01f);
    }
}
