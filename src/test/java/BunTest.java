import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("test", 2.5f);
        Assert.assertEquals("test",bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("test", 2.5f);
        Assert.assertEquals(2.5f,bun.getPrice(),0);
    }

}
