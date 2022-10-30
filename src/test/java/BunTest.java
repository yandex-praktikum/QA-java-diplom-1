import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("black bun", 100);
        String actual = bun.getName();
        String expected = "black bun";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("white bun", 200);
        int actual = (int) bun.getPrice();
        int expected = 200;
        Assert.assertEquals(expected, actual);
    }
}
