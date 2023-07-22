import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParametersTest {
    private String name;
    private float price;

    public BunParametersTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                {"White Bun", 11f},
                {null, 0f},
                {"", 3f},
                {"  ", 3.14f},
                {"!@#$%^&*()", -12f},
                {"Greyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy Bun", Float.MAX_VALUE},
                {"B", Float.MIN_VALUE}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.01);
    }
}
