package praktikum.bun.test.suit;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class GetPriceBunTest {
    @Test
    public void bunGetPriceTest() {
        float price = 770;
        Bun testBun = new Bun("stopWar", price);
        assertEquals(price, testBun.getPrice(), 0);
    }
}
