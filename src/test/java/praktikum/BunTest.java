package praktikum;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BunTest {

    private Bun bun;
    private final String TEST_NAME = "bulka";
    private final float TEST_PRICE = 10.5f;

    @Before
    public void setUp() {
        bun = new Bun(TEST_NAME, TEST_PRICE);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        String actual = bun.getName();
        assertEquals("Неверное имя булки", TEST_NAME, actual);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        float actual = bun.getPrice();
        assertEquals("Неверная цена булки", TEST_PRICE, actual, 0);
    }

}