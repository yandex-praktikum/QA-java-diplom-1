import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


public class TestBun {
    String testName = randomAlphabetic(new Random().nextInt(20));
    Float testPrice = new Random().nextFloat() * 1000;
    Bun bun = new Bun(testName, testPrice);

    @Test
    public void testGetName() {
        Assert.assertEquals("name is not equal", testName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(testPrice, bun.getPrice(), 0.001);
    }
}
