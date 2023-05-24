import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Краторная булка N-200i", 1255);

    @Test
    public void checkGetNameReturnsCorrectValue(){
        String expectedName = "Краторная булка N-200i";
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetPriceReturnsCorrectValue(){
        float expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

}
