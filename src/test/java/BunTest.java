import org.junit.Test;
import praktikum.Bun;
import org.junit.Assert;

public class BunTest {
    @Test
    public void getNameReturnCorrectValue() {
        Bun bun = new Bun("Плюшка", 50);
        String expectedName= "Плюшка";
        String actualName = bun.getName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void getPriceReturnCorrectValue() {
        Bun bun = new Bun("Плюшка", 50);
        float expectedPrice= 50;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice,actualPrice,0.001);
    }

}
