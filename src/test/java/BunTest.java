import praktikum.Bun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;

    @Before
    public void setBun() {
        bun = new Bun("КосмоБулка", 50.25f);
    }

    @Test
    public void getNameReturnBunName() {
        Assert.assertEquals("Неверное имя булочки для бургера", "КосмоБулка", bun.getName());
    }

    @Test
    public void getPriceReturnBunPrice() {
        Assert.assertEquals("Неверная цена булочки для бургера", 50.25f, bun.getPrice(), 0);
    }
}
