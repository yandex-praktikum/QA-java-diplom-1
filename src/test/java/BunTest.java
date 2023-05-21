import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;


public class BunTest {

    private static final int LENGTH_OF_BUN_NAME = 10;

    private String bunName;
    private float bunPrice;

    @Before
    public void beforeMethod() {
        bunName = RandomStringUtils.randomAlphabetic(LENGTH_OF_BUN_NAME);
        bunPrice = new Random().nextFloat();
    }

    @Test
    public void getNameBun() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Invalid value for getName() method", bunName, bun.getName());
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Invalid value for getPrice() method", bunPrice, bun.getPrice(), 0.0f);
    }
}
