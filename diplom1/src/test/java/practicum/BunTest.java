package practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class BunTest {
    String randomName = RandomStringUtils.randomAlphabetic(10);
    float randomPrice = ThreadLocalRandom.current().nextFloat();
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(randomName, randomPrice);
    }

    @Test
    public void getNameShouldReturnValidName() {
        assertEquals(randomName, bun.getName());
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        assertEquals(randomPrice, bun.getPrice(), 0);
    }
}
