import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("С кунжутом", 10);
    }

    @Test
    public void checkCompositionTest() {
        String expected = "С кунжутом";
        String actual = bun.getName();

        assertEquals("Проверим что булочка с кунжутом", expected, actual);
    }

    @Test
    public void checkWrongCompositionTest() {
        String expected = "С кокосом";
        String actual = bun.getName();

        assertNotEquals("Проверим что булочка не с кокосом", expected, actual);
    }

    @Test
    public void checkPriceTest() {
        int expected = 10;
        int actual = bun.getPrice();

        assertEquals("Проверим корректную цену", expected, actual);
    }

    @Test
    public void checkWrongPriceTest() {
        int expected = 15;
        int actual = bun.getPrice();

        assertNotEquals("Проверим некорректную цену", expected, actual);
    }
}