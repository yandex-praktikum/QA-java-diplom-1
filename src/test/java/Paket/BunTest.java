package Paket;

import praktikum.Bun;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("white bun", 100);
        String expectedName = "white bun";
        String actualName = bun.getName();
        Assert.assertEquals("Ошибка в названии булочки", expectedName, actualName);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("red bun", 300);
        float expectedPrice = 300;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Ошибка в цене булочки", expectedPrice, actualPrice,0);
    }
}
