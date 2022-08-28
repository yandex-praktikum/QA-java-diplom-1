package praktikum.bun;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test public void getNameTest(){
        Bun bun = new Bun("Булка1", (float) 56.6);
        String actual = bun.getName();
        Assert.assertEquals(bun.name,actual);
    }

    @Test public void getPriceTest(){
        Bun bun = new Bun("Булка1", (float) 56.6);
        float actual = bun.getPrice();
        Assert.assertEquals(bun.price,actual,0);
    }
}
