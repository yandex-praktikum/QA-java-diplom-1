import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

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
                {"Маленькая булочка", 0.0000001},
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
        assertEquals(price, bun.getPrice(), TestConstant.DELTA);
    }
}