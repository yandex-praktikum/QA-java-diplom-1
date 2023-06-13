package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса /src/main/java/Bun.
 */
@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;

    public BunTest(String nameBun, float priceBun) {
        bun = new Bun(nameBun, priceBun);
    }

    @Parameterized.Parameters(name = "nameBun: {0}; priceBun: {1}")
    public static Object[][] getBun() {
        return new Object[][]{
                {"Меркурианская", 50.0f},
                {"Space", 0},
                {null, 50},
                {"777", 0},
                {"", 0.25f },
                {"@#$%", -100.5f}
        };
    }

    @Test
    public void getNameExpectedEqualsActual() {
        // {0 - expected} {1 - actual}
        assertEquals(bun.name, bun.getName());
    }

    @Test
    public void getPriceExpectedEqualsActual() {
        // {1 - expected} {2 - actual}
        assertEquals("Error getPrice", bun.price, bun.getPrice(), 0);
    }
}