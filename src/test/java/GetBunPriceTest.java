import org.junit.Test;
import praktikum.Bun;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class GetBunPriceTest {
    @Test
    public void canGetBunPrice(){
        float price = new Random().nextFloat();
        Bun bun = new Bun("name", price);
        assertEquals(price, bun.getPrice(),price-bun.getPrice());
    }
}