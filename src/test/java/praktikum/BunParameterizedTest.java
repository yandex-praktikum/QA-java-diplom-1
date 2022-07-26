package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    public String name;
    public float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100f},
                {"", 200f},
                {null, 200f},
                {"black bun", 0},
                {"blackefefefefefefefefefefefefe", 0},
                {"fef-fe", 0},
                {"b", -1},
                {"black bun", 999999999999f},
                {"black bun", -0.01f}
        };
    }

    @Test
    public void getBunName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals("Актуальный результат отличается от ожидаемого", name, actual);
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals("Актуальный результат отличается от ожидаемого", price, actual, 0);
    }
}