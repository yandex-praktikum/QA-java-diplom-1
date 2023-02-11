import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getNameBlackBunTrue() {
        assertEquals("Названия булочек должны совпадать", "black bun", bun.getName());
    }

    @Test
    public void getPriceOneHundredTrue() {
        assertEquals("Цены булочек должны совпадать", 100, bun.getPrice(), 0.01);
    }
}
