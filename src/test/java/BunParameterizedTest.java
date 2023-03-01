import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 10},
                {"", 0},
                {null, -10},
                {"Miracle_Long_Bun_Miracle_Long_Bun", 3.4E+38f},
                {"856492", 40.123456f},
                {"!@#$%^&*()", 4.7E-23f},
        };
    }

    @Test
    public void getNameWithDifferentDataShows() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceWithDifferentDataShows() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}