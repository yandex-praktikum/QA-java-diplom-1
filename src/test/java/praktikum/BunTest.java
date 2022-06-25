package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private static final double DELTA = 1e-15;

    @Test
    public void checkCorrectNameTest() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        assertEquals("The name is not correct", expectedName, actualName);
    }

    @Test
    public void checkCorrectPriceTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        float expectedPrice = 988;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, DELTA);

    }
}