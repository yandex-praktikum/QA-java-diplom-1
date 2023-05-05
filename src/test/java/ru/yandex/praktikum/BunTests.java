package ru.yandex.praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private final String nameExpect;
    private final float priceExpect;
    private Bun bun;

    public BunTests(String nameExpect, float priceExpected) {
        this.nameExpect = nameExpect;
        this.priceExpect = priceExpected;
    }
    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][]{
                {"tttthhhhhhhhiiiiisssss name of bun", 1f},
                {"", Float.MAX_VALUE},
                {"0", Float.MIN_VALUE},
                {"()&*^%$#@!_", 0f},
                {"0987654321", 345323.533f},
                {"null", -99999f}
        };
    }

    @Test
    public void bunGetNameCreateTest() {
        bun = new Bun(nameExpect, priceExpect);
        Assert.assertEquals(nameExpect, bun.getName());
    }

    @Test
    public void bunGetPriceCreateTest() {
        bun = new Bun(nameExpect, priceExpect);
        assertEquals(priceExpect, bun.getPrice(), 0);
    }
}