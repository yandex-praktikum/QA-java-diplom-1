import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Белая Булка", 100f},
                {"Ржаная булка", 202.2f},
                {"Серая булка", 145.5f},
                {"Булка пармезан", 178.9f},
        };
    }

    @Test
    public void returnActualBunNameTest() {
        Bun bun = new Bun(name, price);
        String returnName = bun.getName();
        Assert.assertEquals(name, returnName);
    }

    @Test
    public void returnActualBunPriceTest() {
        Bun bun = new Bun(name, price);
        float returnPrice = bun.getPrice();
        Assert.assertEquals(price, returnPrice, 0);
    }
}
