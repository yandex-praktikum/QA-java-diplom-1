import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunPriceTest {
    private Bun bun;
    private final float price;

    public BunPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {-1.00f},
                {0},
                {Float.MIN_VALUE},
                {Float.MAX_VALUE},
        };
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        bun = new Bun("test", price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
