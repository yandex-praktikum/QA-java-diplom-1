import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("umwelt", 42);

    @Test
    public void bunGetNameTest() {
        Assert.assertEquals("Авария в корпусе имени bun", "umwelt", bun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        Assert.assertEquals("Авария в отсеке цены bun", 42, bun.getPrice(), 0);
    }
}
