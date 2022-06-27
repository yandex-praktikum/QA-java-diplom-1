import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    String bunName = "Булка";
    int bunPrice = 100;
    Bun bun = new Bun(bunName,bunPrice);

    @Test
    public void isBunNameCorrectTest() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void isBunPriceCorrectTesr() {
        assertEquals(bunPrice, bun.getPrice(), 0);
    }

}
