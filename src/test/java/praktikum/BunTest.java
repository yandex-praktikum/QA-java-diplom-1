package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun testBun;
    private String bunName;
    private Float bunPrice;

    @Before
    public void setUp() {
        bunName = RandomStringUtils.randomAlphabetic(10);
        bunPrice = (float) Math.random();
        testBun = new Bun(bunName, bunPrice);
    }

    @Test
    public void bunGetNameTest() {
        assertEquals("Название булки неверное",bunName, testBun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        assertEquals("Стоимость булки неверная",bunPrice, testBun.getPrice(), 2.1f);
    }
}
