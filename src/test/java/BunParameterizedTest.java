import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][] {
                {"blue bun", 100},
                {"green bun", 200},
                {"red bun", 300},
                {null, 1},
                {"asdfg", 147f},
                {"", 0}
        };

    }

    @Before
    public void startTest() {
        bun = new Bun(name, price);

    }
    @Test
    public void checkGetValidName() { assertEquals("invalid name", name, bun.getName()); }

    @Test
    public void checkGetValidPrice() { assertEquals("invalid price", price, bun.getPrice(), 0.0f); }
}