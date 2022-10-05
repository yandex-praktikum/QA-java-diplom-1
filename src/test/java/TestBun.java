import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBun {

    String name = "Булка";
    float price = 100;
    Bun bun = new Bun(name, price);

    @Test
    public void checkBunGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkBunGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
