package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    @Test
    // "getName возвращает заданное имя"
    public void getName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    // "getPrice возвращает заданную цену"
    public void getPrice() {
        Bun bun = new Bun("white bun", 200);
        assertEquals(200, bun.getPrice(), 0);
    }
}