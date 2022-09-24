package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    // Тест получение название булочки
    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun("black bun", 200);
        String expectedName = "black bun";

        String realName = bun.getName();
        Assert.assertEquals(expectedName, realName);
    }

    // Тест получения цены булочки
    @Test
    public void getPriceReturnsPrice() {
        Bun bun = new Bun("black bun", 200);
        float expectedPrice = 200;

        float realPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, realPrice, 0);
    }
}
