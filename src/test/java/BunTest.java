import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    /**
     * Собрал варианты для тестов модели булочки.
     * Вариант: имя модели, цена.
     */
    @Parameterized.Parameters(name = "Вариант: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {"Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_Long_name_long_price_", 3.4E+38f},
                {"!@#$%^&*()_-long_price",  3.4E-38f},
                {"01234567890", 11.7f},
                {"Step", 1},
                {"", 0},
                {null, -1}
        };
    }

    @Test
    public void checkNameVariableTests() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkPriceVariableTests() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
