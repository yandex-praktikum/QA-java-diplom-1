package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    String nameTestBun = "Pi-Bun";
    float priceTestBun = 3.14F;

    @Before
    public void setUp() {
        bun = new Bun(nameTestBun, priceTestBun);
    }

    @Test
    public void getNameBun() {
        String actual = bun.getName();
        assertEquals(nameTestBun, actual);
    }

    @Test
    public void getPriceBun() {
        float actual = bun.getPrice();
        assertEquals(priceTestBun, actual, 0);
    }
}