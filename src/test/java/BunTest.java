import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("test bun", 1.0f);

    @Test
    public void testGetName(){
         Assert.assertEquals("test bun", bun.getName());
    }

    @Test
    public void testGetPrice(){
        Assert.assertEquals(1, bun.getPrice(), 0);
    }

}
