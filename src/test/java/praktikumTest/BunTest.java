package praktikumTest;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void setNameOfBun() {
        Bun bun = new Bun("Pizza", 2.38f);
        Assert.assertEquals("Pizza", bun.getName());
    }

    @Test
    public void setCorrectPrice() {
        Bun bun = new Bun("test_name", 2.31f);
        Assert.assertEquals(2.31f, bun.getPrice(), 0.0);
    }
}
