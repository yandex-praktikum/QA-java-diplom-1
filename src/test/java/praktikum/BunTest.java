package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    public static final float BUN_PRICE = 5F;
    public static final String BUN_NAME = "булочка";

    @Test
    public void getPrice() {
        Bun bunTest = new Bun(BUN_NAME, BUN_PRICE);
        float actual = bunTest.getPrice();
        Assert.assertEquals(actual, BUN_PRICE, 0);
    }


    @Test
    public void getName() {
        Bun bunTest = new Bun(BUN_NAME, BUN_PRICE);
        var actual = bunTest.getName();
        Assert.assertEquals(actual, BUN_NAME);
    }
}
