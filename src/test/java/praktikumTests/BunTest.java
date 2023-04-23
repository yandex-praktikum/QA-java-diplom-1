package praktikumTests;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void bunConstructorTest() {
        Bun bun = new Bun("TEST", 178.0f);
        assertEquals("TEST", bun.getName());
        assertEquals(178.0f, bun.getPrice(), 0.0f);
    }

}
