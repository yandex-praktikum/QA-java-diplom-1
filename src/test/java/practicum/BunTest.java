package practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void getNameShouldReturnValidNameWhenNameIsEmpty() {
        Bun anotherBun = new Bun("", randomPrice);
        assertEquals("", anotherBun.getName());
    }

    @Test
    public void getNameShouldReturnValidNameWhenNameIsNull() {
        Bun anotherBun = new Bun(null, randomPrice);
        assertNull(anotherBun.getName());
    }

    @Test
    public void getNameShouldReturnValidNameWhenNameIsLong() {
        Bun anotherBun = new Bun("ThisIsAbsolutelyLongNameForAbsolutelyDeliciousBun", randomPrice);
        assertEquals("ThisIsAbsolutelyLongNameForAbsolutelyDeliciousBun", anotherBun.getName());
    }

    @Test
    public void getPriceShouldReturnValidValueWhenPriceIsZero() {
        Bun anotherBun = new Bun(randomName, 0);
        assertEquals(0, anotherBun.getPrice(), 0);
    }

    @Test
    public void getPriceShouldReturnValidValueWhenPriceIsNegative() {
        Bun anotherBun = new Bun(randomName, -10);
        assertEquals(-10, anotherBun.getPrice(), 0);
    }

    @Test
    public void getPriceShouldReturnValidValueWhenPriceIsFloated() {
        Bun anotherBun = new Bun(randomName, 0.555f);
        assertEquals(0.555f, anotherBun.getPrice(), 0);
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        assertEquals(randomPrice, bun.getPrice(), 0);
    }
}
