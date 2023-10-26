package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private final String BUN_NAME = "Bulochka";
    private final float BUN_PRICE = 1388;

    @Test
    public void getName() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        Assert.assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        Assert.assertEquals(BUN_PRICE, bun.getPrice(),0.000000000000001);
    }
}