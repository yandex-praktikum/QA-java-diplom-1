import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Simple Bun", 150);
    }

    @Test
    public void returnBunNameTest(){
        String actualName = bun.getName();
        String expectedName = "Simple Bun";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void returnPriceTest(){
    float actualPrice = bun.getPrice();
    float expectedPrice = 150;
    Assert.assertEquals(expectedPrice,actualPrice, 0);
    }

}
