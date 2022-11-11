import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("White bun", 250);
    }

    @Test
    public void getBunNameReturnTest() {
        String actualResult = bun.getName();
        String expectedResult = "White bun";

        Assert.assertEquals( expectedResult, actualResult);
    }

    @Test
    public void getBunPriceReturnTest() {
        float actualResult = bun.getPrice();
        float expectedResult = 250;

        Assert.assertEquals( expectedResult, actualResult, 0);
    }
}