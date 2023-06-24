import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("softBun", 60.0f);
        String expected = "softBun";
        String actual = bun.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("softBun", 60.0f);
        float expected = 60.0f;
        float actual = bun.getPrice();

        Assert.assertEquals(expected, actual, 0.0f);
    }
}
