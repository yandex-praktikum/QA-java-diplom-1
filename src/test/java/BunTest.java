import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;

public class BunTest {
    @Mock
    Bun bun;
    String actualName = "Burger";
    float actualPrice = 156;

    @Before
    public void setUp() {
        bun = new Bun(actualName, actualPrice);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(bun.getName(), actualName);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(bun.getPrice(), actualPrice, 0.0f);
    }
}
