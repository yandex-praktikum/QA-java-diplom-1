import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void getBunNameReturnsCorrectValueTest(){
        Bun bun = new Bun("bulka", 0.0f);
        Assert.assertEquals("Incorrect bun's name ", bun.getName(), "bulka");
    }

    @Test
    public void getBunPriceReturnsCorrectValueTest() {
        Bun bun = new Bun("bulka", 100.0f);
        Assert.assertEquals("Incorrect price", 100,bun.getPrice(), 0.0f);
    }
}
