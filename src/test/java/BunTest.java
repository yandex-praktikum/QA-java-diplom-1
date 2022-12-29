import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;
    private final String testBunName = "Юнит-тестовая булка";
    private final float testBunPrice = 1478.12f;

    @Before
    public void init() {
        bun = new Bun(testBunName, testBunPrice);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(testBunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(testBunPrice, bun.getPrice(), 0);
    }

}
