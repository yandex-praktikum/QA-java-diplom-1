import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void createNewBun(){
        bun = new Bun("black bun", 100.0f);
    }

    @Test
    public void testGetName() {
        String expected = "black bun";
        String actual = bun.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        float expected = 100.0f;
        float actual = bun.getPrice();

        Assert.assertEquals(expected, actual, 0.0f);
    }

}
