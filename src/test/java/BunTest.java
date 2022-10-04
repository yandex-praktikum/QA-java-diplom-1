import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest extends BaseTest {

    private final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private final float BUN_PRICE = 988F;

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
