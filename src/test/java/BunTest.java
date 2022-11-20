import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Булка", 100);
    }

    @Test // тест метода названия булки
    public void getNameTest() {
        String actual = bun.getName();
        assertEquals("Булка", actual);
    }

    @Test // тест метода цены булочки
    public void getPriceTest() {
        float actual = bun.getPrice();
        assertEquals(100, actual, 0);
    }
}
