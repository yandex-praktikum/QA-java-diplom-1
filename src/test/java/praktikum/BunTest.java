package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String nameBun;
    private final float priceBun;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(nameBun, priceBun);
    }

    public BunTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters(name = "nameBun: {0}; priceBun: {1}")
    public static Object[][] getBun() {
        return new Object[][]{
                {"Меркурианская", 50.0f},
                {"Space", 0},
                {null, 50},
                {"777", 0},
                {"@#$%", -100.5f}
        };
    }

    @Test
    public void getNameExpectedEqualsActual() {
        // {0 - expected} {1 - actual}
        Assert.assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getPriceExpectedEqualsActual() {
        // {1 - expected} {2 - actual}
        Assert.assertEquals("Error getPrice", priceBun, bun.getPrice(), 0);
    }
}