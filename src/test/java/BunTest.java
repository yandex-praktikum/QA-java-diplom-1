import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private String expected1;
    private float expected2;

    public BunTest(String name, float price, String expected1, float expected2) {
        this.name = name;
        this.price = price;
        this.expected1 = expected1;
        this.expected2 = expected2;
    }

    @Parameterized.Parameters(name = "{index}: sort[{0}]={1}")
    public static Object[][] parameterizedTest() {
        return new Object[][] {
                {"Черная булка", 50f, "Черная булка", 50f},
                {"Белая булка", 75f,"Белая булка", 75f}
        };
    }

    @Test
    public void getNameReturnsNameOfBun() {
        Bun bun = new Bun(name, price);
        assertEquals(expected1, bun.getName());
    }

    @Test
    public void getPriceReturnsPriceOfBun() {
        Bun bun = new Bun(name, price);
        assertEquals(expected2, bun.getPrice(), 0);
    }
}
