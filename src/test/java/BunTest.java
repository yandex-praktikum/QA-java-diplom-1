
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun;
    @Test
    public void testBun(){
        bun = new Bun("Bun", 123.0f);
        assertEquals("Bun", bun.getName());
        assertEquals(123.0f, bun.getPrice(), 0.001);

    }
}
