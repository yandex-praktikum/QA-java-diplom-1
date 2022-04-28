import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;


public class BunTest {

    //Unit test for Bun Class
    @Test
    public void burgerCreateTest() {
        String name = RandomStringUtils.randomAlphabetic(10);
        Float price = new Random().nextFloat();

        Bun bun = new Bun(name, price);
        Assert.assertEquals("burger name doesn't coincide with expected", name, bun.name);
        Assert.assertEquals("burger price doesn't coincide with expected", price, bun.price, 0);
        Assert.assertEquals("burger name and method burger.getName() doesn't coincide", name, bun.getName());
        Assert.assertEquals("burger price and method burger.getPrice() doesn't coincide", price, bun.getPrice(), 0);
    }


}