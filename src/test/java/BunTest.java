import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Test
    public void getNameTest(){
        Bun bun = new Bun("kfkf", 200);
        //Assert.assertEquals(200, bun.getPrice(), 0);
        Assert.assertEquals("kfkf", bun.getName());
    }
    @Test
    public void getPriceTest(){
        Bun bun = new Bun("kfkf", 200);
        Assert.assertEquals(200, bun.getPrice(), 0);
        //Assert.assertEquals("kfkf", bun.getName());
    }
}
