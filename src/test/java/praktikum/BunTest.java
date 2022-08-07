package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private String name;
    private float price;

    @Test
    public void getNameReturnBunName() {
        name = "black bun";
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(name, actualName);
    }
    @Test
    public void getPriceReturnBunPrice () {
        price = 200f;
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
