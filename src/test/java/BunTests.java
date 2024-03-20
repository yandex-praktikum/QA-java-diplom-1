import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {
    private final String name = "bun";
    private final float price = 10;
    private Bun bun;

    @Before
    public void bun() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(),0);
    }
}
