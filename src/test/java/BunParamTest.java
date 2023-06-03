import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String nameBun;
    private final float priceBun;

    public BunParamTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Хлеб", 100},
                {"Bread", 100},
                {"ХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлебХлеб", 100},
                {"Х", 100},
                {"", 100},
                {null, 100},
                {"11111", 100},
                {"!!!*?%:№", 100},
                {"Хлеб", 0},
                {"Хлеб", -100},
                {"Хлеб", Float.MIN_VALUE},
                {"Хлеб", Float.MAX_VALUE},
                {"Хлеб", (float) 0.723972356293},

        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(nameBun, priceBun);
        assertEquals(priceBun, bun.getPrice(), 0);
    }
}

