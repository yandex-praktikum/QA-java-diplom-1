package bun;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Вкусняга";
    private final float price = 237;
    Bun bun = new Bun(name, price);

    @Test
    public void getNameReturnName() {
        assertEquals("Вкусняга", bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        assertEquals(237.0, bun.getPrice(), 0.01);
    }
}
