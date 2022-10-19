package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun("test", 103.0f);
        assertEquals("test", bun.getName());
        assertEquals(103.0f, bun.getPrice(), 0.0f);
    }
}

