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
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"black bun", 50F},
                {"булка", 15},
                {"@#$%^$", 150},
                {"", 1F}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, 100F);
        String actName = bun.getName();
        Assert.assertEquals("Имя булочки не верное", name, actName);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", price);
        float actPrice = bun.getPrice();
        Assert.assertEquals("Цена булочки не верная", price, actPrice, 0.0f);
    }
}