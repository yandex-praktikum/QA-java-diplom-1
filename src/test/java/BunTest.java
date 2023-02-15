import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String name;
    private float price;


    @Test
    public void getNameReturnsValidName() {
        Bun bun  = new Bun(name, price);
        String actualResult = bun.getName();
        String expectedResult = name;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceReturnsValidPrice() {
        Bun bun  = new Bun(name, price);
        float actualResult = bun.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }



}
