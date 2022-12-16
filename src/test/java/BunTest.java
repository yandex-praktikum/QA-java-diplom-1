import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    String bunName;
    float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] allBuns() {
        return new Object[][] {
                {"black bun", 100F},
                {"white bun", 200F},
                {"red bun", 300F},
        };
    }
    /**
     * Проверка, что метод возвращает название булочки
     */
    @Test
    public void getNameSomeBunTest() {
        Bun bun = new Bun(bunName, bunPrice);
        String actual = bun.getName();
        Assert.assertEquals(bunName, actual);
    }

    /**
     * Проверка, что метод возвращает цену булочки
     */
    @Test
    public void getPriceSomeBunTest() {
        Bun bun = new Bun(bunName, bunPrice);
        float actual = bun.getPrice();
        Assert.assertEquals(bunPrice, actual, 0.05);
    }
}
