package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;
    String name = "С кунжутом";
    float price = 2.99f;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals("Имя не соответствует ожидаемому", name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Цена не соответствует ожидаемой", price, bun.getPrice(), 0.01);
    }
}