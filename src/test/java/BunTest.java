import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

public class BunTest {

private Bun bun = new Bun("Test", 10);

    @Test
    public void getNameReturnThisName(){
    Assert.assertEquals(bun.name, bun.getName());
    }

    @Test
    public void getPriceReturnThisPrice(){
        Assert.assertEquals(bun.price, bun.getPrice(), 0);
    }

}
