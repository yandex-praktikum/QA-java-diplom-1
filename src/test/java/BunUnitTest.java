import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunUnitTest {
    @Test
    public void testGetBunName() {
        Bun bun = new Bun("Hamburger Bun", 1.99f);
        String name = bun.getName();
        Assert.assertEquals("Hamburger Bun", name);
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun("Hamburger Bun", 1.99f);
        float price = bun.getPrice();
        Assert.assertEquals(1.99f, price, 0.01f);
    }
}
