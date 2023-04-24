package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовое имя: {0}, Тестовая цена: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"bulochka", 100},
                {"", 100},
                {" ", 100},
                {" bulochka", 100},
                {"bulochka ", 100},
                {"vkusnaya bulochka", 100},
                {"bulochka", 0},
                {"bulochka", -1},
                {"bulochka", 1},
                {"bulochka", 100.99f},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Имена не совпадают", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена не совпадает",price, bun.getPrice(), 0);
    }
}