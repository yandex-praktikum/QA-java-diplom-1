import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    final String bunName = "fluorescent bun";
    final int bunPrice = 988;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getBunNameTest() {
        String actualBunName = "fluorescent bun";
        String expectedBunName = bun.getName();
        Assert.assertEquals("Expected bun name - fluorescent bun", expectedBunName, actualBunName);
    }
    @Test
    public void getBunPriceTest() {
        float expectedBunPrice = 988;
        float actualBunPrice = bun.getPrice();
        Assert.assertEquals("Expected bun price - 988", expectedBunPrice, actualBunPrice, 0);
    }
}