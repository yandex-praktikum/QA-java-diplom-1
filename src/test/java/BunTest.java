import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;


    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{0},{1},{2},{3}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Test", 299, "Test", 299},
                {"Test", -1, "Test", -1},
                {"Test", 0, "Test", 0},
                {null, 30, null, 30},
        };
    }

    @Test
    public void bunCreateTest() {
        Bun actualBun = new Bun(name, price);
        assertEquals(expectedName, actualBun.getName());
        assertEquals(expectedPrice, actualBun.getPrice(), 0.0001);
    }
}
