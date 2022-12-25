import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("black bun", 100);

    @Test
    public void getNameTest() {
        String extendedName = "black bun";
        String actualName = bun.getName();
        Assert.assertEquals("There should be another name", extendedName, actualName);
    }

    @Test
    public void getPriceTest() {
        float extendedPrice = 100;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(extendedPrice, actualPrice, 0);
    }
}
