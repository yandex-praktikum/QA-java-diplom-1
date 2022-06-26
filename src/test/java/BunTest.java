import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameReturnsCorrectName() {
        Bun bun = new Bun("С кунжутом", 0);
        String expectedName = "С кунжутом";
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun(null, 1.5f);
        float expectedPrice = 1.5f;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}
