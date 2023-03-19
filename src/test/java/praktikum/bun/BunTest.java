package praktikum.bun;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.util.BunsInfo;


public class BunTest {
    @Test
    public void checkNameBun() {
        String name = BunsInfo.RED.getName();
        Bun bun = new Bun(name, 25.0F);
        Assert.assertEquals("Wrong name of bun", name, bun.getName());
    }

    @Test
    public void checkPriceBun() {
        float price = BunsInfo.WHITE.getPrice();
        Bun bun = new Bun("name", price);
        Assert.assertEquals("Wrong price of bun", price, bun.getPrice(), 0.0F);
    }
}