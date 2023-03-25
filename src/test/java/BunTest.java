import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    public static int bunPrice = 300;
    public static String bunName = "red bun";
    Bun bun;

    @Test
    public void getName() {
        bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}