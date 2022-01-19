package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void initObjectsBun() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void getBunNameTest() {
        String actual = bun.getName();
        String expected = "Флюоресцентная булка R2-D3";
        assertEquals(expected, actual);
    }

    @Test
    public void getBunPriceTest() {
        double actual = bun.getPrice();
        double expected = 988.0;
        assertEquals(expected, actual, 0);
    }
}