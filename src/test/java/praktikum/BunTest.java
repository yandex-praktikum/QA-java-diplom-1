package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Before
    public void createBunObject() {
        bun = new Bun("Краторная булка N-200i", 1255f);
    }

    @Test
    public void getNameReturnsCorrectNameTest() {

        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPriceTest() {

        float expectedPrice = 1255f;
        float actualPrice = bun.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }
}
