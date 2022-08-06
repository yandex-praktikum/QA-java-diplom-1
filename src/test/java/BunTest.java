import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setup() {
        bun = new Bun("TestBun", 123.453f);
    }

    @Test
    public void testGetName() {
        String actual = bun.getName();
        String expected = "TestBun";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        float actual = bun.getPrice();
        float expected = 123.453f;
        assertEquals(expected, actual, 1e-15);
    }

}
