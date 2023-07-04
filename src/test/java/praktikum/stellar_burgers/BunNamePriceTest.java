package praktikum.stellar_burgers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunNamePriceTest {
    private final String name;
    private final float price;

    public BunNamePriceTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Стоимость булочки. Тестовые данные: {0} {1}")
    public static Object[][] testData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void bunNamePriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
