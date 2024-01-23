package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getName() {
        String name = "Булочка с кунжутом";
        Bun bun = new Bun(name,0);
        String actual = bun.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void getPrice() {
        float price = 50;
        Bun bun = new Bun("Булочка с кунжутом",price);
        float actual = bun.getPrice();
        Assert.assertEquals(price, actual,0);
    }
}