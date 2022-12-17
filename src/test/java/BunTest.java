import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    String bunName = "Test bun name";
    float bunPrice = 1234.56f;
    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getBunNameNameGet() {
        Assert.assertEquals("Name is not correct", bunName, bun.getName());
    }

    @Test
    public void getBunPricePriceGet() {
        Assert.assertEquals("Price is not correct", bunPrice, bun.getPrice(), 0.001);
    }

}
