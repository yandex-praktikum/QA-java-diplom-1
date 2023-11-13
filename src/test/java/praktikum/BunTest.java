package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetters() {
        Bun bun = new Bun("testBun", 50);
        assertEquals("testBun", bun.getName());
        assertEquals(50, bun.getPrice(), 0.001);
    }
}




