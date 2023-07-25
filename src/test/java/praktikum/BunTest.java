package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] paramTest() {
        return new Object[][]{
                {"", 10.5f},
                {"тестовая", 0f},
                {"b-!u//nbunbubububububububbubuub+", -100.001f},
                {null, 1f}
        };
    }

    @Test
    public void checkGetNameAndGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.0);
    }

}