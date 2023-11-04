import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Star bun";
    private final float price = 200;

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.1);
    }
}
