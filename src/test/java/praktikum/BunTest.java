package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;
    String name = RandomStringUtils.randomAlphabetic(10);
    float price = ThreadLocalRandom.current().nextFloat();

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameShouldReturnValidName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
