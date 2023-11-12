import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {
    @Test
    public void getBunNameTest() {
        Bun bun = new Bun("test bun", 200);
        assertEquals("test bun", bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("test bun", 200);
        assertEquals(200.0f, bun.getPrice(), 0.01);
    }
}
