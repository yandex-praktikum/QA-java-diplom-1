package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void bunGetName() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Assert.assertEquals("Краторная булка N-200i", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Assert.assertEquals(1255, bun.getPrice(),0);
    }
}
