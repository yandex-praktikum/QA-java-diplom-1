import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest extends BaseTest {

    String bunName = "BUN";
    float bunPrice = 450;

    @Test
    public void getBunName() {
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getBunPrice() {
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
