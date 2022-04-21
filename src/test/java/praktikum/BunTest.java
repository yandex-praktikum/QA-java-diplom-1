package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;

import static org.apache.commons.lang3.RandomUtils.nextFloat;

public class BunTest {

    @Test
    public void methodGetNameShouldReturnSameName() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void methodGetPriceShouldReturnSamePrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        float price = nextFloat();

        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.001);
    }
}
