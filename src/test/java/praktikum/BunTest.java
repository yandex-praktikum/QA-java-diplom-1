package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Булочка с кунжутом>", 100);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Цена не совпадает с ожидаемым значением", 100, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Булочка с кунжутом", 100);
        String actualName = bun.getName();
        Assert.assertEquals("Название не совпадает с ожидаемым значением", "Булочка с кунжутом", actualName);
    }
}
