package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedBunPriceTest {

    private final String bunName;
    private final Float bunPrice;

    public ParameterizedBunPriceTest(String bunName, Float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters( name = "{0} - bunName, " +
            "{1} - bunPrice")

    public static Object[][] bunTestData() {
        return new Object[][] {
                { "regularBun", 0F},
                { "regularBun", -1.5f},
                { "regularBun", 0.000001F},
                { "regularBun", 1.456f},
                { "regularBun", Float.MAX_VALUE},
                { "regularBun", Float.MIN_VALUE},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        Float expected = bunPrice;
        Float actual = bun.getPrice();
        assertEquals(expected, actual, 0.0000001F);
    }
}
