import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    Bun bun;
    private final String expectedName = "Классическая булка";
    private final float expectedPrice = 70;

    @Before
    public void setUp(){
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();
        Assert.assertEquals("Неправильное имя", expectedName, actualName);

    }
    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Неправильная цена", expectedPrice, actualPrice,1);
    }
}
