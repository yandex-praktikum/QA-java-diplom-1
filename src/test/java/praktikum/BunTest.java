package praktikum;


import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BunTest {

    private static final String NAME = "DIABOLO";
    private final static float PRICE = new Random().nextFloat();

    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals("'Name' is correct", NAME, bun.getName());
        assertNotEquals("'Name' is not correct", EMPTY, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("'Price' is correct", PRICE, bun.getPrice(), 0);
        assertNotEquals("'Price' is not correct", PRICE + 0.1f, bun.getPrice(), 0);
    }
}