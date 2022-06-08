import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String name = "Булка";
    private final float price = 5;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String nameBunActual = bun.getName();
        String message = "Не удалось получить название булочки";
        assertEquals(message, name, nameBunActual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float priceActual = bun.getPrice();
        String message = "Не удалось получить цену булочки";
        assertEquals(message, price, priceActual, 0.01);
    }
}
