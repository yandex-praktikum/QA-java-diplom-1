package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private Bun testBun = new Bun("тестовая булка", 45.55F);
    private float expectedPrice = 45.55F;
    private String expectedName = "тестовая булка";

    @Test
    public void bunGetNameTest() {
        Assert.assertEquals(expectedName, testBun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        Assert.assertEquals(expectedPrice, testBun.getPrice(), 0);
    }
}
