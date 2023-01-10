import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String NAME = "BunName";
    private final float PRICE = 100;


    @Test
    public void testGetName() {
        Bun bun = new Bun(NAME, PRICE);
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(NAME, PRICE);
        assertEquals(PRICE, bun.getPrice(), 0);
    }
}
