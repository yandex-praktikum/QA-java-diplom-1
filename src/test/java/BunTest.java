import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final String NAME = "Джанго";
    private final float PRICE = 3.14f;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(PRICE, bun.getPrice(), 0);
    }
}
