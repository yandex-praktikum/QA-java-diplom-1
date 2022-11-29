import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("black bun", 50);

    @Test
    public void checkGetNameBun() {
        Assert.assertEquals("black bun", bun.getName());
    }

    @Test
    public void checkGetPriceBun() {
        Assert.assertEquals(50, bun.getPrice(), 0);
    }
}
