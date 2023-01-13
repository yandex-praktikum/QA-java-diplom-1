package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest{
    Bun bun = new Bun("Bulochka", 10);

    @Test
    public void getName() {
        Assert.assertEquals("Bulochka", bun.getName());
    }
    @Test
    public void getPrice() {
        Assert.assertEquals(10, bun.getPrice(),0);
    }
}
