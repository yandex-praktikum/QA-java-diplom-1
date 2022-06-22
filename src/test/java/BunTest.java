import praktikum.Bun;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    private float price;
    private String name;

    @Test
    public void getPriceTest() {
        price = 200.49f;
        Bun bun = new Bun("black bun", price);
        float priceActual = bun.getPrice();
        assertEquals(price, priceActual, 0);
    }

    @Test
    public void getNameTest() {
        name = "black bun";
        Bun bun = new Bun(name, 45.49f);
        String nameActual = bun.getName();
        assertEquals(name, nameActual);
    }
}