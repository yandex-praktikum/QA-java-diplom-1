import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest extends BaseTest {

    private static final Bun bun = new Bun(expectedBunName, expectedBunPrice);

    @Test
    public void getName() {
        Assert.assertEquals(expectedBunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(expectedBunPrice, bun.getPrice(), testDelta);
    }
}
