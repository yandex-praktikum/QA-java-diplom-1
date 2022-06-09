import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    String name = "black bun";
    float price = 15.5f;

    @Test
    public void getPriceCorrectResultTest(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals("Ошибка в цене", price, actualPrice, 0.0f);
    }

    @Test
    public void getNameCorrectResultTest(){
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("Ошибка в названии", name, actualName);
    }
}
