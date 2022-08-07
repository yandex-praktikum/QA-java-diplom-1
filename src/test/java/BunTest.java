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
    public static Object[] buns() {
        return new Object[][] {
                { "white bun", 50f },
                { "black bun", 60f },
        };
    }

    @Test
    public void checkGetName() {
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName());
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Bun bun = new Bun(name, price);
        System.out.println(bun.getPrice());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
