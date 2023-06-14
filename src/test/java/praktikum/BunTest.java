package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("white bun", 200);
        assertEquals("white bun", bun.getName());
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0);
    }
}

