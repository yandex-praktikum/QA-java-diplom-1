package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest extends BaseTest {

    private final String NAME = RandomStringUtils.randomAlphabetic(8);
    private final float PRICE = RandomUtils.nextFloat();
    private Bun bun;

    @Before
    public void setUp() {
        this.bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Неверное название булочки", NAME, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Неверная цена булочки", PRICE, bun.getPrice(), FLOAT_DELTA);
    }
}