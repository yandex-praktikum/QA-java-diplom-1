package bun_param_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamNameAndPriceTest {
    private final float expectedPrice;

    private final String expectedName;
    private final String name;
    private final float price;

    public BunParamNameAndPriceTest(float price, String name, float expectedPrice, String expectedName) {
        this.price = price;
        this.name = name;
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters(name = "{index}: Тест цены и наименования: {0}, {1}, Ожидаемый результат, {2}, {3}")
    public static Object[][] checkNameAndPrice() {
        return new Object[][]{
                {100, "black bun", 100, "black bun"},
                {200, "white bun", 200, "white bun"},
                {300, "red bun", 300, "red bun"},
        };
    }

    @Test
    public void checkNameAndPriceTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(expectedName, actual);
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0);
    }
}
