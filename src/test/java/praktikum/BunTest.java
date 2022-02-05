package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private String expectedName;
    private float expectedPrice;
    private Bun bun;

    @Before
    public void setUp() {
        expectedName = "Wheat Bun";
        expectedPrice = 41.99f;
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();
        assertEquals("Bun names are no equal",
                expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();
        assertEquals("Prices are not equal",
                expectedPrice, actualPrice, 0);
    }
}