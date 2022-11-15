import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void newBun() {
        bun = new Bun("test name", 13.37f);
    }
    @Test
    public void shouldGetName() {
        assertEquals("test name", bun.getName());
    }
    @Test
    public void shouldGetPrice() {
        assertEquals(13.37f, bun.getPrice(), 0);
    }
}
