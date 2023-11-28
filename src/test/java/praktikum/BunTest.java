package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;
    @Before
    public void init() throws Exception {
        bun = new Bun("Булочка", 100.0F);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название не совпадает","Булочка", bun.getName());
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена не совпадает", 100.0F, bun.getPrice(), 0);
    }
}
