package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    String name = "crater bun";
    float price = 150;

    @Test
    public void getNameBunTest(){
        Bun bun = new Bun(name, price);
        String expected = "crater bun";
        Assert.assertEquals(expected, bun.getName());
    }

    @Test
    public void getPriceBunTest(){
        Bun bun = new Bun(name, price);
        float expected = 150;
        Assert.assertEquals(expected, bun.getPrice(), 0);
    }
}