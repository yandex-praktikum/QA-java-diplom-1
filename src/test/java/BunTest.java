import praktikum.Bun;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    String name = "Burger";
    float price = 3.5F;
    Bun bun = new Bun(name, price);
    @Test
    public void getName() {
        String expected = name;
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPrice() {
        float expected = price;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual,0);
    }
}