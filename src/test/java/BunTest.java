import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String bunName = "tastyBun";
    private float bunPrice = 75.8f;

    @Test
    public void getNameShouldReturnName() {
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceShouldReturnPrice() {
        bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.0);
    }
}
