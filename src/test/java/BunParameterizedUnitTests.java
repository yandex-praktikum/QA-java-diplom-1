package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedUnitTests {
    private final String name;
    private final float price;

    public BunParameterizedUnitTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters (name="Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                        {"Флюоресцентная булка R2-D3", 988.025f},
                        {"Краторная булка N-200i", 1255}
        };
    }

    @Test
    public void getNameBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
