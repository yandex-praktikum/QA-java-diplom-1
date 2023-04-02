import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("name", 20.00f);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Assert.assertEquals("name", bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Assert.assertEquals(20.00f, bun.getPrice(), 0);
    }
}
