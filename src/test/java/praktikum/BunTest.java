package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BunTest {
    Bun bun;
    private String bunName = "Ciabatta";
    private float bunPrice = 15;

    @Before
    public void createBunObject(){
        this.bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
