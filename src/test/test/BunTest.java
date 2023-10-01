import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest extends BaseTest {

    private static final Bun bun = new Bun(expectedName, expectedPrice);

    @Test
    public void getName() {
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(expectedPrice, bun.getPrice(), testDelta);
    }
}
