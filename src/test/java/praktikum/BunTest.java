package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;

    @Before
    public void setup() {
        bun = new Bun("Bun", 1f);
    }

    @Test
    public void getNameTest() {
        String result = bun.getName();
        String expected = "Bun";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getPriceTest() {
        float result = bun.getPrice();
        float expected = 1f;
        Assert.assertEquals(expected, result, 0.01f);
    }
}
