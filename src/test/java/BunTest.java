import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final String expectName;
    private final float expectPrice;


    public BunTest(String name, float price, String expectName, float expectPrice) {
        this.name = name;
        this.price = price;
        this.expectName = expectName;
        this.expectPrice = expectPrice;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Test", 100500, "Test", 100500},
                {null, 100500, null, 100500},
                {"Test", 0, "Test", 0},
                {"Test", -1, "Test", -1}
        };
    }

    @Test
    public void bunCreateTest() {
        Bun actualBun = new Bun(name, price);
        assertEquals(expectName, actualBun.getName());
        assertEquals(expectPrice, actualBun.getPrice(), 0.0001);
    }
}
