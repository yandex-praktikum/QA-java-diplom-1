package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String nameBun;
    private final float priceBun;

    public BunTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
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
    public void getName() {
        Bun bun = new Bun(nameBun, priceBun);
        String actual = bun.getName();
        String expected = nameBun;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(nameBun, priceBun);
        float actual = bun.getPrice();
        float expected = priceBun;
        Assert.assertEquals("Error getPrice",expected,actual,0);
    }
}