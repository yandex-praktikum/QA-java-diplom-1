package praktikum.bun_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

/**
 * Демонстрация параметризации теста на валидных данных для цены
 */

@RunWith(Parameterized.class)
public class BunPriceTestParam {
    @Parameterized.Parameter(0)
    public String comment;
    @Parameterized.Parameter(1)
    public float priceExpected;
    @Parameterized.Parameter(2)
    public String defaultName;
    private float priceActual;

    @Parameterized.Parameters(name = "comment : {0}, priceExpected : {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Положительное целое число", 100, "black bun"},
                {"Положительное дробное число", 100.1F, "black bun"},
                {"Ноль", 0, "black bun"},
                {"Ноль с точкой", 0.0F, "black bun"},
        };
    }

    @Test
    public void getPriceValidValueReturnValidBunPrice() {
        Bun bun = new Bun(defaultName, priceExpected);
        priceActual = bun.getPrice();
        assertEquals(comment, priceActual, priceExpected, 0);

    }

}
