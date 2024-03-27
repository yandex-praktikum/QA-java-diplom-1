import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("white", 104.5F);

    @Test
    public void testGetBunName(){
        Assert.assertEquals("white", bun.getName());
    }

    @Test
    public void testGetBunPrice(){
        Assert.assertEquals(104.5F,bun.getPrice(),0);
    }
}
