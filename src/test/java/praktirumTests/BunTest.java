package praktirumTests;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void bunConstructorTest() {
        Bun bun = new Bun("TEST", 103.0f);
        assertEquals("TEST", bun.getName());
        assertEquals(103.0f, bun.getPrice(), 0.0f);
    }
}

