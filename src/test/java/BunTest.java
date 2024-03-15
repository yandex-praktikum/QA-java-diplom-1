import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;
public class BunTest {

    Random r = new Random();
    String name = "someName";
    float price = 0 + r.nextFloat() * (5);
    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("someName", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0f);
    }
}
