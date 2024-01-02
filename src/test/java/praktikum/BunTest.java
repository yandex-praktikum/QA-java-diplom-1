package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 2.5f);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("white bun", 3.0f);
        assertEquals(3.0f, bun.getPrice(), 0.001); // Проверяем с погрешностью из-за float
    }

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun("red bun", 2.0f);
        assertEquals("red bun", bun.getName());
        assertEquals(2.0f, bun.getPrice(), 0.001);
    }
}
