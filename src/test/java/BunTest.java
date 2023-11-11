import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("С кунжутом", 5);
    }

    @Test
    public void checkCompositionTest() {
        String expected = "С кунжутом";
        String actual = bun.getName();

        assertEquals("Проверим из чего состоит булочка", expected, actual);
    }

    @Test
    public void checkPriceTest() {
        int expected = 5;
        int actual = bun.getPrice();

        assertEquals("Проверим цену", expected, actual);
    }
}