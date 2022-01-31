import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {

        Bun bun = new Bun("Gary", 12);
        String actualName = bun.getName();
        String expectedName = "Gary";

        assertEquals("Имя не совпадает", actualName, expectedName);

    }

    @Test
    public void getPriceTest() {

        Bun bun = new Bun("Gary", 12);
        int actualPrice = (int) bun.getPrice();
        int expectedPrice = 12;

        assertEquals("Цена не совпадает", actualPrice, expectedPrice);

    }
}
