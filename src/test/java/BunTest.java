import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final float price;
    private final String name;
    Bun bun;

    public BunTest(float price, String name) {
        this.price = price;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
                { (float) 100, "black bun"},
                { (float) 200, "white bun"},
        };
    }
    @Before
    public void setUp() {
        bun = new Bun (name, price);
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.001);
    }
    @Test
    public void getNameTest() {
        Assert.assertEquals(name, bun.getName());
    }
}