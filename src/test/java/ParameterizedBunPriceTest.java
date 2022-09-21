import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBunPriceTest {
    private final String burgerName;
    private final float burgerPrice;
    public ParameterizedBunPriceTest(String burgerName, float burgerPrice) {
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Superburger", 300F},
                {"Superburger", 99999999.99F},
                {"Superburger", -99999999.99F},
                {"Superburger", 0.01F},
                {"Superburger", -0.01F},
                {"Superburger", 0},
        };
    }

    @Test
    public void getPriceReturnsPrice() {
        Bun bun = new Bun(burgerName, burgerPrice);

        float actual = bun.getPrice();

        assertEquals("Returns incorrect price", burgerPrice, actual, 0);
    }
}
