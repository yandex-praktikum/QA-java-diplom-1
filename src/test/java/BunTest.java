import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest extends BaseTest{
    private static final Bun bun = new Bun(bunName, bunPrice);


    @Test
    public void getNameAssertReturnValueTest(){
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceAssertReturnValueTest(){
        Assert.assertEquals(bunPrice, bun.getPrice(), testDeltaRange);
    }
}
