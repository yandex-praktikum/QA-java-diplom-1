package praktikum.bun;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class GetPriceBunTest {

    @Test
    public void bunGetNameTest() {
        String name = "umwelt";
        Bun testBun = new Bun(name, 770);
        assertEquals(name, testBun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        float price = 770;
        Bun testBun = new Bun("stopWar", price);
        assertEquals(price, testBun.getPrice(), 0);
    }
}
