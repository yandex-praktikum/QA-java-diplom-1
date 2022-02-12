package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void testGetNameReturnCorrectName() {
        Assert.assertEquals("Bun's name should be \"Black bun\"", "black bun", bun.getName());
    }

    @Test
    public void testGetPriceReturnCorrectPrice() {
        Assert.assertEquals("Bun's price should be 100", 100, bun.getPrice(), 0);
    }
}