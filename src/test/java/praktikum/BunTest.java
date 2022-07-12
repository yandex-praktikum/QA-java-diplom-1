package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void initObject() {
        bun = new Bun("white bun", 200);
    }

    @Test
    public void shouldReturnBunName() {
        String actual = bun.getName();
        String expected = "white bun";
        assertEquals("Get bun name error", expected, actual);
    }

    @Test
    public void shouldReturnBunPrice() {
        Float actual = bun.getPrice();
        Float expected = 200f;
        assertEquals("Get bun price name error", expected, actual);
    }
}
