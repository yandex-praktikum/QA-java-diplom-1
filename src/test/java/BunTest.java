import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    final String BUN = "red bun";
    final int BUN_PRICE = 300;

    @Before
    public void setUp() {
        bun = new Bun(BUN, BUN_PRICE);
    }

    @Test
    public void getNameBunTest() {
        String actualBun = "red bun";
        String expectedBun = bun.getName();
        Assert.assertEquals("Expected bun color - red", expectedBun, actualBun);
    }

    @Test
    public void getPriceBunTest() {
        float expectedPrice = 300;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Expected price - 300", expectedPrice, actualPrice, 0);
    }
}