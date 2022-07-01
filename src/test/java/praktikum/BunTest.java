package praktikum;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class BunTest {

    private Bun bun;

    @Before
    public void setup() {
        bun = new Bun("bunny", 0.05f);
    }

    @Test
    public void getBunNameReturnsCorrectValue() {
        String expectedName = "bunny";

        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getBunPriceReturnsCorrectValue() {
        float expectedPrice = 0.05f;

        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @After
    public void tearDown() {
        bun = null;
    }
}
