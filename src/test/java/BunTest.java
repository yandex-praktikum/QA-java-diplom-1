import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

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
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Булочка", 50},
                {"Simple bun", 0.000001},
                {"", 0},
                {"Буууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууууулочка", 9999999999.99F}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice());
    }
}