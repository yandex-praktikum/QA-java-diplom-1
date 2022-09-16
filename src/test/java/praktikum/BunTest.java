package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100L);
    }

    @Test
    public void getNameBunTest() {
        String actual = "black bun";
        String expected = bun.getName();
        Assert.assertEquals("Ожидаемое название булочки - ", expected, actual);
    }

    @Test
    public void getPriceBunTest() {
        float expected = 100L;
        float actual = bun.getPrice();
        Assert.assertEquals("Ожидаемая цена булочки - " + expected, expected, actual, 0);
    }
}