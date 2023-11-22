package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private Bun testBun = new Bun("тестовая булка", 45.55F);

    @Test
    public void bunGetNameTest() {
        Assert.assertEquals("тестовая булка", testBun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        Assert.assertEquals(45.55F, testBun.getPrice(), 0);
    }
}
