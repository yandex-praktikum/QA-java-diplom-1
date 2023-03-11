package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("первый", 34);
        Assert.assertEquals("первый", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("первый", 34);
        Assert.assertEquals(34, bun.getPrice(), 1);
    }

}
