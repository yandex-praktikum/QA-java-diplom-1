import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    @Test
    public void getName() {
        bun = new Bun("red bun", 300);
        Assert.assertEquals("red bun", bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun("red bun", 300);
        Assert.assertEquals(300, bun.getPrice(), 0);
    }
}