import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    @Test
    public void getPriceTest() {
        Bun bun = new Bun("Космическая", 100);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Цена не совпадает с ожидаемым значением", 100, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Космическая", 100);
        String actualName = bun.getName();
        Assert.assertEquals("Название не совпадает с ожидаемым значением", "Космическая", actualName);
    }
}

