import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun;

    @Before
    public void bunCreation(){
        bun = new Bun("black bun", 100);
    }

    @Test
    public void getNameReturnNameTest(){
        String expectedTesult = "black bun";
        String actualResult = bun.getName();
        Assert.assertEquals(expectedTesult, actualResult);
    }

    @Test
    public void getPriceReturnPriceTest(){
        float expectedResult = 100;
        float actualResult = bun.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }
}
