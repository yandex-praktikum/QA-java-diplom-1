package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Наименование = {0}; Цена = {1}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {"Флюоресцентная булка R2-D3", -988},
                {"Краторная булка N-200i", 0},
                {"Обычная булка", 2345},
                {"", 1234},
                {null, 12345},
                {"1", 123456},
                {"!@#", 1234567},
                {"QwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbЙцукенгшщзхъфывапролджэячсмитьбюйцукенгшщзхъфывапр", 4321}
        };
    }

    @Test
    public void checkBuns() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}