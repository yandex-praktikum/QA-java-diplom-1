import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    String name = "name";
    float price = 100F;

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getNPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
