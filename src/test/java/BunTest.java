import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("name", 2.00F);
        Assert.assertEquals("name", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("name", 2.00F);
        Assert.assertEquals(2.00F, bun.getPrice(), 0);
    }
}
