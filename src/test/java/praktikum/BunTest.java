package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("test", 15);
        Assert.assertEquals(bun.getName(), "test");
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("test", 12);
        Assert.assertEquals(bun.getPrice(), 12,0);
    }
}