import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBuns() {
        return new Object[][] {
                {"cream bun", 59},
                {"fruit bun", 63},
                {"cinnamon bun", 99}
        };
    }

    @Test
    public void checkBunsNameAndPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Expected result does not match the actual", name, bun.getName());
        Assert.assertEquals("Expected result does not match the actual", price, bun.getPrice(), 0);
    }
}
