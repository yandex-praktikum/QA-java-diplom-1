import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setBun() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getBunNameTest() {
        String actual = bun.getName();
        String expected = "Краторная булка N-200i";
        assertEquals(expected, actual);}

    @Test
    public void getBunPriceTest() {
        double actual = bun.getPrice();
        double expected = 1255.0;
        assertEquals("Цена булки не совпадает с ожидаемой", expected, actual, 0);
    }
}