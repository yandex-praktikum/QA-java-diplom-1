package praktikum;
import org.junit.*;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("TestBurger", 22.55f);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("TestBurger", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(22.55f, bun.getPrice(), 0.01);
    }
}
