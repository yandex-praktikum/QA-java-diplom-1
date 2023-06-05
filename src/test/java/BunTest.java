import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    public Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("pancake", 12.5f);
    }

    @Test
    public void getNameBun() {
        Assert.assertEquals("pancake", bun.getName());
    }

    @Test
    public void getPriceBun() {
        Assert.assertEquals(12.5f, bun.getPrice(), 0.1f);
    }
}

