package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BunTest {

    private final String name = RandomStringUtils.randomAlphabetic(1, 5);
    private final float price = new Random().nextFloat();

    private final Bun bun = new Bun(name, price);

    @Test
    public void bunGetNameTest() {

        assertEquals(name, bun.getName());
    }

    @Test
    public void bunGetPriceTest() {

        assertEquals(price, bun.getPrice(), 0.0f);
    }

}