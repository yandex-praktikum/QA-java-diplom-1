import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Кратерная булка", 100.00f);

    @Test
    public void getNameReturnName() {
        String expectedName = "Кратерная булка";
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnPrice() {
        float expectedPrice = 100.00f;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0f);
    }

}
