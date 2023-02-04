package praktikum.bunTests;

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
    public float priceProvided;
    @Parameterized.Parameter(2)
    public float priceActual;

    @Parameterized.Parameters(name = "comment : {0}, priceProvided : {1}, priceActual : {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Положительное целое число", 100, 100},
                {"Положительное дробное число", 100.1F, 100.01F},
                {"Ноль", 0, 0},
                {"Ноль с точкой", 0.0F, 0.0F},
        };
    }

    @Test
    public void getPriceValidValueReturnValidBunPrice() {
        Bun bun = new Bun("black bun", priceProvided);
        priceActual = bun.getPrice();
        assertEquals(priceActual, priceProvided, 0);

    }

}
