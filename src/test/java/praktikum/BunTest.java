package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getName() {
        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(100, bun.getPrice(), 0);
    }
}