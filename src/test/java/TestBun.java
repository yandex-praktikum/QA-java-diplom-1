import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBun {

    @Test
    public void bunGetNameReturnsNameTest(){
        Bun bun = new  Bun("black bun",100);
        Assert.assertEquals("black bun",bun.getName());

    }

    @Test
    public void bunGetPriceReturnsPriceTest(){
        Bun bun = new  Bun("white bun",200);
        Assert.assertEquals(200,bun.getPrice(), 0);

    }
}
