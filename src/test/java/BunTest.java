import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameTest() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPriseTest() {
        assertEquals(100, bun.getPrice(), 1);
    }
}
