package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String nameExpect;
    private final float priceExpect;
    private Bun bun;

    public BunTest(String nameExpect, float priceExpected) {
        this.nameExpect = nameExpect;
        this.priceExpect = priceExpected;
    }
    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][]{
                {"Name of bun", 500f},
                {"      ", 300f},
                {" Name ", 250.0000f},
                {"null", -200f},
                {null, -200f},
                {"", Float.MAX_VALUE},
                {"0", Float.MIN_VALUE},
                {"()&*^%$#@!_", 0f},
                {"0987654321", 345323.533f}
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