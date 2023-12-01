package praktikum.stellarburgers.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collections;

@RunWith(Parameterized.class)
public class BunTest {
    private final String NAME;
    private final float PRICE;

    public BunTest(float price, String name) {
        this.NAME = name;
        this.PRICE = price;
    }

    @Parameterized.Parameters(name = "Bun test ( name: {1}, price: {0} )")
    public static Object[][] getTestData() {
        return new Object[][]{
                {Float.NaN, "Rare bun"},
                {Float.MAX_VALUE, "Rare bun"},
                {3.402823499E38f, "Rare bun"},
                {1000.001f, "Rare bun"},
                {1.4E-45f, "Rare bun"},
                {0, "Rare bun"},
                {-1.4E-45f, "Rare bun"},
                {-1000.001f, "Rare bun"},
                {-3.402823499E38f, "Rare bun"},
                {Float.MIN_VALUE, "Rare bun"},
                {1234.5678f, null},
                {1234.5678f, "Very " + String.join(" ", Collections.nCopies(100, "very")) + " long bun"},
                {1234.5678f, ""},
                {1234.5678f, "   "},
                {1234.5678f, "Regular bun"},
                {1234.5678f, "Very rare '(~@&%$*)' bun"}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(NAME, PRICE);
        Assert.assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(NAME, PRICE);
        Assert.assertEquals(PRICE, bun.getPrice(), 0);
    }
}
