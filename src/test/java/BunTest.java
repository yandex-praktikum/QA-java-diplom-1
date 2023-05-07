import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void getBunNameTest(){
    Bun bun= new Bun("black bun",100);
    Assert.assertEquals("black bun",bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun= new Bun("black bun",100);
        Assert.assertEquals(100,bun.getPrice(),0);
    }
}
