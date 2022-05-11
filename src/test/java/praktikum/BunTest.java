package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    public String name;
    public float price;
    public Bun bun;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(5);
        price = RandomUtils.nextInt(5, 500);
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0);
    }

}