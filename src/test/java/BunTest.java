import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", 100);
        float actual = bun.getPrice();
        assertEquals(100, actual, 0.0f);
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun("white bun", 50);
        String actual = bun.getName();
        assertEquals("white bun", actual);
    }
}
