package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name_bun;
    private final float price_bun;

    public BunTest(String name_bun, float price_bun) {
        this.name_bun = name_bun;
        this.price_bun = price_bun;
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
        Bun bun = new Bun(name_bun, price_bun);
        String actual = bun.getName();
        String expected = name_bun;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name_bun, price_bun);
        float actual = bun.getPrice();
        float expected = price_bun;
        Assert.assertEquals("Error getPrice",expected,actual,0);
    }
}