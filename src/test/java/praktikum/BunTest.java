package praktikum;
import org.junit.*;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Булка", 22.55f);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Булка", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(22.55f, bun.getPrice(), 0);
    }
}
