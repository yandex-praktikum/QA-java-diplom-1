import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void verifyCreateBunTest() {
        Bun bun = new Bun("bunn", 0.99f);
        Assert.assertEquals(0.99, bun.getPrice(), 0.000001);//
        Assert.assertEquals("bunn", bun.getName());//
    }
}
