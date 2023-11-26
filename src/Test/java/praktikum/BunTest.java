package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameTest() {
        String expected = "black bun";
        String actual = bun.getName();
        Assert.assertEquals("Ошибка при получении названия булки", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 100;
        float actual = bun.getPrice();
        Assert.assertEquals("Ошибка при получении цены булки", expected, actual, 0);
    }
}