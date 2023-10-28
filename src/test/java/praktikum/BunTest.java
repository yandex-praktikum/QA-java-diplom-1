package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {" ", 988},
                {"Соус фирменный Space Sauce", 988.0f},
                {null, 1255.0f},
                {"Bulka123", 988},
                {"Краторная булка N-200i", 0},
                {"Флюоресцентная булка R2-D3", -988},
        };
    }


    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(actualPrice, price, 0.001);
    }
}
