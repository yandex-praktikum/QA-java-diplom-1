package praktikum.test.parameterized.bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class GetPricePositiveResultParameterizedTest {
    private final String name;
    private final float price;


    public GetPricePositiveResultParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Стоимость булочки. Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Булочка", 0},
                {"Булочка", -10f},
        };
    }

    @Test
    public void getPriceBunWithIncorrectPrice() {
        Bun bun = new Bun(name, price);
        boolean result = bun.getPrice() > 0f;
        Assert.assertFalse(result);
    }
}
