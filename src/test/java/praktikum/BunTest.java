package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void createNewInstance() {
        bun = new Bun("black bun", 100.1f);
    }

    @Test
    public void initializeBunCheckName() {
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals(expected, actual);
    }

    @Test
    public void initializeBunCheckPrice() {
        float actual = bun.getPrice();
        float expected = 100.1f;
        assertEquals(expected, actual, 0);
    }
}
