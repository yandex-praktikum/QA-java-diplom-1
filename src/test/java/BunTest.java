import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest extends BaseTest {

    private final String BUN_NAME = "BUN";
    private final float BUN_PRICE = 450.5F;

    @Test
    public void getBunName() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getBunPrice() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
        assertEquals(BUN_PRICE, bun.getPrice(), 0);
    }
}
