package praktikum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

    @Test
    public void testNameNull() {
        Bun bun = new Bun(null, TEST_PRICE);
        assertNull("Имя булки должно быть null", bun.getName());
    }

    @Test
    public void testNameEmpty() {
        Bun bun = new Bun("", TEST_PRICE);
        assertEquals("Имя булки должно быть пустой строкой", "", bun.getName());
    }

    @Test
    public void testNameLong() {
        String longName = "bulka".repeat(100);
        Bun bun = new Bun(longName, TEST_PRICE);
        assertEquals("Неверное длинное имя булки", longName, bun.getName());
    }

    @Test
    public void testNameSpecialCharacters() {
        String specialName = "@#$%^&*()_+";
        Bun bun = new Bun(specialName, TEST_PRICE);
        assertEquals("Неверное имя булки со спецсимволами", specialName, bun.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPriceNegative() {
        new Bun(TEST_NAME, -1.0f);
    }

    @Test
    public void testPriceZero() {
        Bun bun = new Bun(TEST_NAME, 0.0f);
        assertEquals("Цена булки должна быть равна нулю", 0.0f, bun.getPrice(), 0);
    }

    @Test
    public void testPriceMinimalPositive() {
        float minPrice = Float.MIN_VALUE;
        Bun bun = new Bun(TEST_NAME, minPrice);
        assertEquals("Неверная минимальная положительная цена булки", minPrice, bun.getPrice(), 0);
    }

    @Test
    public void testPriceMaximumPositive() {
        float maxPrice = Float.MAX_VALUE;
        Bun bun = new Bun(TEST_NAME, maxPrice);
        assertEquals("Неверная максимальная положительная цена булки", maxPrice, bun.getPrice(), 0);
    }
}