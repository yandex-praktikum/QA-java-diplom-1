package praktikum;

import org.junit.Assert;
import org.junit.Test;
public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun = new Bun("black bun", 100);
        String expName = "black bun";
        String actName = bun.getName();
        Assert.assertEquals("Имя булочки не верное", expName, actName);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", 100.0f);
        float expPrice = 100;
        float actPrice = bun.getPrice();
        Assert.assertEquals("Цена булочки не верная", expPrice, actPrice, 0);
    }
}