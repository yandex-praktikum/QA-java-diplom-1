package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedBunNameTest {

    private final String bunName;
    private final Float bunPrice;

    public ParameterizedBunNameTest(String bunName, Float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters ( name = "{0} - bunName, " +
            "{1} - bunPrice")

    public static Object[][] bunTestData() {
        return new Object[][] {
                { "regularBun", 15F},
                { "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest" +
                        "veryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTestveryLongStringTest", 15F},
                { "", 15F},
                { null, 15F},
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        String expected = bunName;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
}
