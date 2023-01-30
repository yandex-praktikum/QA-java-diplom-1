import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    Bun bun = new Bun("white bun", 200);
    @Test
    public void getNameTest(){
        Assert.assertEquals("white bun", bun.getName());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(200, bun.getPrice(), 0);
    }
}
