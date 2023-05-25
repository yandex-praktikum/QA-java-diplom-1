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
        return new Object[][] {
                {"white bun", 100F},
                {"red bun", 300F}
        };
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        String actualResult = bun.getName();
        Assert.assertEquals(name, actualResult);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        float actualResult = bun.getPrice();
        Assert.assertEquals(price, actualResult, 0.05);
    }
}
