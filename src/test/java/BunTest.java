import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("black bun", 100);

    @Test
    public void getPriceTest(){
        Assert.assertEquals(100, bun.getPrice(), 0);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("black bun", bun.getName());
    }
}
