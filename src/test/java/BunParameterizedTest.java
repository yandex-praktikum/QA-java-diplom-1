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
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {null, 1},
                {"asdfg", 147f},
                {"black.,; bun", 100f},
                {"white bun/*", 200f},
                {"red bun", -300f},
                {"white bun", 3/5},
                {"red bun", (float)3/5},
                {"black bun", -Float.MAX_VALUE},
                {"white bun", Float.MAX_VALUE},
                {"red bun", Float.MIN_VALUE},
                {"black bun", Float.NEGATIVE_INFINITY},
                {"white bun", Float.POSITIVE_INFINITY},
                {"red bun", -Float.MIN_VALUE},
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