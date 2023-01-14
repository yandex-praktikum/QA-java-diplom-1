import data.Data;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void checkThatBunGetsName() {
        Bun bun = new Bun(Data.BLACK_BUN, Data.BLACK_BUN_PRICE);
        Assert.assertEquals(Data.BLACK_BUN, bun.getName());
    }

    @Test
    public void checkThatBunGetsPrice() {
        Bun bun = new Bun(Data.BLACK_BUN, Data.BLACK_BUN_PRICE);
        Assert.assertEquals(Data.BLACK_BUN_PRICE, bun.getPrice(), 0.0f);
    }
}
