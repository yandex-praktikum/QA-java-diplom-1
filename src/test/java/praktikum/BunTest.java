package praktikum;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class BunTest extends TestCase {
    float price = new Random().nextFloat() * 1000;
    String name = RandomStringUtils.randomAlphabetic(20);
    Bun bun = new Bun(name, price);

    @Test
    public void testGetNameBun() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPriceBun() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
