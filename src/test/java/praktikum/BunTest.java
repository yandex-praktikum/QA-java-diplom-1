package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void testGetters() {
        String bunName = "Bread";
        float bunPrice = 1.0f;
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
        Assert.assertEquals(bunPrice, bun.getPrice(), 0.00001f);
    }
}