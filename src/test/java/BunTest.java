import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetNameReturnsName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988F);
        String actual = bun.getName();
        String expected = "Флюоресцентная булка R2-D3";
        Assert.assertEquals("getName() returns incorrect name of bun", expected, actual);
    }

    @Test
    public void testGetPriceReturnsPrice() {
        Bun bun = new Bun("Краторная булка N-200i", 1255F);
        float actual = bun.getPrice();
        float expected = 1255F;
        Assert.assertEquals("getPrice() returns incorrect price of bun", expected, actual, 0F);
    }
}