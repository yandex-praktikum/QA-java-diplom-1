package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class BunTest {
    String name;
    Float price;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(10);
        price = new Random().nextFloat();
    }


    @Test
    public void checkNameBurger() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("burger name doesn't coincide with expected", name, bun.name);
    }

    @Test
    public void checkPriceBurger() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("burger price doesn't coincide with expected", price, bun.price, 0);
    }

    @Test
    public void checkBurgerNameAndNameMethod() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("burger name and method burger.getName() doesn't coincide", name, bun.getName());
    }

    @Test
    public void checkBurgerPriceAndPriceMethod() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("burger price and method burger.getPrice() doesn't coincide", price, bun.getPrice(), 0);
    }


}