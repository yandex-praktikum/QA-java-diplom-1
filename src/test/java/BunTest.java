import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Abc bun", 100);

        String actualBunName = bun.getName();

        assertEquals("Abc bun", actualBunName);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Abc bun", 100);

        float actualBunPrice = bun.getPrice();

        assertEquals(100, actualBunPrice, 1e-8);
    }
}
