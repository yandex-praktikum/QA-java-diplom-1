package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getName() {
        var expected = "name";
        var bun = new Bun(expected, 100f);
        assertEquals(expected, bun.getName());
    }

    @Test
    public void getPrice() {
        var expected = 100f;
        var bun = new Bun("name", expected);
        assertEquals(expected, bun.getPrice(), 0f);
    }
}