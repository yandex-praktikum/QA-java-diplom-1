import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;
    private String name = "Булочка";
    private float price = 1.5f;

    @Before
    public void setUp(){
        bun = new Bun (name, price);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
