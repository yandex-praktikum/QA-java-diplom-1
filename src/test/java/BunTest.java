import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameBunTest() {
        {
            Bun bun = new Bun("black bun", 100);
            String actual = bun.getName();
            String expected = "black bun";
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void getPriceBunTest() {
        {
            Bun bun = new Bun("black bun", 100);
            float actual = bun.getPrice();
            float expected = 100;
            Assert.assertEquals(actual, expected, 0);
        }
    }
}
