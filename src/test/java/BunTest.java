import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void BunNameTest() {
        Bun bun = new Bun("Классическая", 133.34f);
        assertEquals("Классическая", bun.getName());
    }

    @Test
    public void BunPriceTest() {
        Bun bun = new Bun("Классическая", 133.34f);
        assertEquals(133.34f, bun.getPrice(), 0);
    }
}
