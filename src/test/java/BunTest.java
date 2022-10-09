import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Test
    public void checkBunName() throws Exception {

        Bun bun = new Bun("John", 1000);
        String expected = "John";
        String actual = bun.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void checkBunPrice() throws Exception {

        Bun bun = new Bun("John", 1000);
        float expected = 1000;
        float actual = bun.getPrice();

        assertEquals(expected, actual, 0);
    }
}
