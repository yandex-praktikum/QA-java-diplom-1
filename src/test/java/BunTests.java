import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {
    private Bun bun;
    @Before
    public void setUp() {
        bun = new Bun("white bun", 200);
    }
    @Test
    public void bunGetNameTest() {
        String expected = "white bun";
        String actual = bun.getName();
        Assert.assertEquals("Укажите корректное название булочки", expected, actual);
    }
    @Test
    public void bunGetPriceTest() {
        float expected = 200F;
        float actual = bun.getPrice();
        Assert.assertEquals("Укажите корректную стоимость булочки", expected, actual, 0);
    }
}
