package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testGetName() {
        Bun bun = new Bun("Вкусная", 1150);
        assertEquals("Внимание! Название булочки некорректно", "Вкусная", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Вкусная", 1150);
        assertEquals("Внимание! Цена булочки некорректна", 1150.0, bun.getPrice(), 0);
    }
}