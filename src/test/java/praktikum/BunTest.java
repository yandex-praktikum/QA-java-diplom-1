package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private Bun bun;

    @Test
    public void getName() {
        bun = new Bun("white bun", 200);
        Assert.assertEquals("white bun", bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun("white bun", 200);
        Assert.assertEquals(200, bun.getPrice(), 0);
    }
}
