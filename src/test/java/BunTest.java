import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private static Random random = new Random();
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {randomStringUtils.randomAlphabetic(10), 800.000000000F}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals(price, actual, 0);
    }
}
