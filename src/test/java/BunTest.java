import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    private final String name = "black bun";
    private final float price = 100;
    Bun bun = new Bun(name, price);

    @Test
    public void getNameBun() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun() {
        assertEquals(price, bun.getPrice(), 0);
    }
/* Нужно ли добавить сюда негативные тесты? Примеры ниже. Такой же вопрос и для других классов
    @Test
    public void getNameBunNegative() {
        assertNotEquals("incorrect name", bun.getName());
    }

    @Test
    public void getPriceBunNegative() {
        assertNotEquals(200, bun.getPrice(), 0);
    }
*/
}
