package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getNameTest(){
        String name = bun.getName();
        Assert.assertEquals("black bun", name);
    }

    @Test
    public void getPriceTest(){
        float price = bun.getPrice();
        Assert.assertEquals(100, price, 0.001);
    }
}