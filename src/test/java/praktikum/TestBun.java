package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class TestBun {
    Bun bun;

    @Test
    public void testGetName() {
        bun = new Bun("1234", -1.0f);
        Assert.assertEquals("1234", bun.getName());
    }
    @Test
    public void testGetPrice() {
        bun = new Bun("1234", -1.0f);
        Assert.assertEquals(-1.0f, bun.getPrice(), 0.001f);
    }
}
