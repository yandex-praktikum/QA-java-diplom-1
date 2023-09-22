import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    @Before
    public void setup() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void checkBunGetName() {
        String actualName = bun.getName();
        Assert.assertEquals("black bun", actualName);
    }

    @Test
    public void checkBunGetPrice() {
        Float actual = bun.getPrice();
        Assert.assertEquals(100, actual, 0);

    }

}
