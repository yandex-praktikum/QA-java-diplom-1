package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void getNameReturnCorrectName() {
        Bun bun = new Bun("TestName", 9);
        String actual = bun.getName();
        String expected = "TestName";
        assertEquals(expected, actual);

    }

    @Test
    public void getNameReturnCorrectPrice() {
        Bun bun = new Bun("TestName", 90);
        float actual = bun.getPrice();
        float expected = 90;
        assertEquals(expected, actual, 0);
    }
}
