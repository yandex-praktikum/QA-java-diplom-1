package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String bunName;
    private final float bunPrice;
    private final String expectedBunName;
    private final float expectedBunPrice;

    public BunParameterizedTest(String bunName, float bunPrice, String expectedBunName, float expectedBunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Bun", 1.95f, "Bun", 1.95f},
                {"Bulka", 0, "Bulka", 0},
                {"", 5, "", 5},
                {"Bulo4ka", 99.99f, "Bulo4ka", 99.99f},
        };
    }

    @Test
    public void shouldBeCreateBunWithNameAndPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(expectedBunName, bun.getName());
        assertEquals(expectedBunPrice, bun.getPrice(), 0.0);
    }
}