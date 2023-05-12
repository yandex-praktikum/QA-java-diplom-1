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
                {"bun", 10},
                {"", 10},
                {" ", 10},
                {" bun", 10},
                {"#bun", 10},
                {"bunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbunbun", 10},
                {"tasty bun", 10},
                {"bun", 0},
                {"bun", -1},
                {"bun", Float.MIN_VALUE},
                {"bun",3.4E+38f},
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Имя", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена",price, bun.getPrice(), 0);
    }
}