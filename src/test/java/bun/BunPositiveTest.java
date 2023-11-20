package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunPositiveTest {
    private final String name;
    private final float price;
    public BunPositiveTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "buns: {0},{1}")
    public static Object[] data() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }
    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String expectedName = name;
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }
    @Test
    public void getPriceTest(){
        Bun bun = new Bun(name, price);
        Float expectedFloat = price;
        Float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedFloat, actualPrice);
    }
}
