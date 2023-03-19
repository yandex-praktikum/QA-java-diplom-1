package praktikum.bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


//@RunWith(Parameterized.class)
public class BunTests {
    //todo сделать 1 тест но с параметризацией
    @Test
    public void checkNameBun() {
        String name = "Пита";
        Bun bun = new Bun(name, 25.0F);
        Assert.assertEquals("Wrong name of bun", name, bun.getName());
    }

    @Test
    public void checkPriceBun() {
        float price = 24.0F;
        Bun bun = new Bun("name", price);
        Assert.assertEquals("Wrong price of bun",  price, bun.getPrice(),0.0F);
    }
}