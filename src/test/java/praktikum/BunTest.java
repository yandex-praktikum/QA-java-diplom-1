package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("Мягкая булка", 24.5f);

    @Test
    public void getName() {
        Assert.assertEquals("Мягкая булка", bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(24.5f, bun.getPrice(), 0);
    }
}
