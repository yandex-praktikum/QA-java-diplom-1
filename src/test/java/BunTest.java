import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun;

    @Test
    public void getNameTest() {
        String expected = "name";
        bun = new Bun(expected, 100F);
        Assert.assertEquals(expected, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float expected = 100F;
        bun = new Bun("name", expected);
        Assert.assertEquals(expected, bun.getPrice(), 0);
    }

}
