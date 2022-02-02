import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import java.util.Random;


public class GetBunPriceTest {
    @Test
    public void canGetBunPrice(){
        float price = new Random().nextFloat();
        Bun bun = new Bun("name", price);
        Assert.assertEquals(price, bun.getPrice(),price-bun.getPrice());
    }
}