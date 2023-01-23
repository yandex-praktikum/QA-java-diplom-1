import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;

    String name;

    float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Булочка - {0} Цена - {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"", Float.MAX_VALUE},
                {"!@#!$%^&*()_~", 0f},
                {null, -99999f},
                {"234234234", 345323.533f},
                {"САМЫЙ ПОПУЛЯРНЫЙ СРЕДИ ПОСЕТИТЕЛЕЙ СТАРБУРГЕР КАФЕ БУРГЕР КОТОРЫЙ ВЫ МОЖЕТЕ ЗАКАЗАТЬ С БЕКОНОМ ИЛИ БЕЗ", 1f},
                {"0", Float.MIN_VALUE}
        };
    }

    @Before
    public void preBun() {
        bun = new Bun(name,price);
    }

    @Test
    public void checkGetName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}