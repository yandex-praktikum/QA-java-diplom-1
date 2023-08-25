import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static final String BUN_NAME = "Булочка с кунжутом";
    private static final float BUN_PRICE = 20;
    Bun bun = new Bun(BUN_NAME, BUN_PRICE);

    @Test
    public void getNameCorrectValue() {
        String expectedValue = BUN_NAME;
        String actualValue = bun.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriceCorrectValue() {
        float expectedValue = BUN_PRICE;
        float actualValue = bun.getPrice();
        assertEquals(expectedValue, actualValue, 0.00);
    }
}
