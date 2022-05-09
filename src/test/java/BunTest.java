import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void createBug() {
        bun = new Bun("bugName", Float.MAX_VALUE);
    }

    @Test
    public void getNameBugTest() {
        Assert.assertEquals("Название булочки не соответствует ожидаемому", "bugName", bun.getName());
    }

    @Test
    public void getPriceBugTest() {
        Assert.assertEquals("Цена на булочку не соответствует ожидаемой", Float.MAX_VALUE, bun.getPrice(), 0.000001);
    }
}
