package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedBunPriceTest {

    private final String bunName;
    private final float bunPrice;

    public ParameterizedBunPriceTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters( name = "{0} - bunName, " +
            "{1} - bunPrice")

    public static Object[][] bunTestData() {
        return new Object[][] {
                { "regularBun", 15F},
                { "regularBun", 0},
                { "regularBun", -1.5f},
                { "regularBun", 0.000001F},
                { "regularBun", 1.456f},
                //{ "regularBun", null}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        float expected = bunPrice;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 1.0);


    }
}
