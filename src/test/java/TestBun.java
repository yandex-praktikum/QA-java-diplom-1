import org.testng.Assert;
import org.testng.annotations.Test;
import praktikum.Bun;

public class TestBun {
    @Test
    public void getNameTest() {
        String expectedName = "testName";
        float price = 123;
        Bun bun = new Bun(expectedName, price);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        String name = "testName";
        float expectedPrice = 123;
        Bun bun = new Bun(name, expectedPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}
