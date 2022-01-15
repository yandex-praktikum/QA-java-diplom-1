import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        Assert.assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        Assert.assertEquals(988.0, bun.getPrice(), 0);
    }

}
