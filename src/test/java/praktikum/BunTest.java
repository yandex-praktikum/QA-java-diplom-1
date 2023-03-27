package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BunTest {
    private final String VALID_NAME = "Кратор";
    private final float VALID_PRICE = 777.7f;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(VALID_NAME, VALID_PRICE);
        Assert.assertEquals(VALID_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(VALID_NAME, VALID_PRICE);
        Assert.assertEquals(VALID_PRICE, bun.getPrice(), 0);
    }

    @Test
    @Parameters({"Булка",
            "БулкаБулкаБулкаБулка",
            "BulkaBulka",
            "Булка Булка"})
    public void positiveCreateBunNameParams(String name) {
        Bun bun = new Bun(name, VALID_PRICE);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(VALID_PRICE, bun.getPrice(), 0);
    }

    @Test
    @Parameters({"0.01",
            "500.1",
            "10000"})
    public void positiveCreateBunPriceParams(float price) {
        Bun bun = new Bun(VALID_NAME, price);
        Assert.assertEquals(VALID_NAME, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
