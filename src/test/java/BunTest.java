import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BunTest {
    @Test
    public void getNameReturnBunName() {
        Bun bun = new Bun("name", 1);
        String expectedName = "name";
        String actualName = bun.getName();
        assertEquals ("Неверное имя", expectedName, actualName);
    }
    @Test
    public void getPriceReturnBunPrice() {
        Bun bun = new Bun("name", 1);
        float expectedPrice = 1;
        float actualPrice = bun.getPrice();
        assertEquals("Неверная цена", expectedPrice, actualPrice, 0);
    }
}