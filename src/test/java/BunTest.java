import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.BunGenerator;

import static org.junit.Assert.assertEquals;

public class BunTest {
   Bun bun;

    @Before
    public void setUp() {
        bun = BunGenerator.getRandomLoginPriceForBun();
    }

    @Test
    public void testNameBun() {
        String actual = bun.getName();
        String expected = BunGenerator.bunName;
        assertEquals("Получено некорректное имя для булочки",expected, actual);
    }

    @Test
    public void testPriceBun() {
        float actual = bun.getPrice();
        float expected = 109;
        assertEquals("Получена некорректная цена для булочки",expected, actual, 0);
    }

}
