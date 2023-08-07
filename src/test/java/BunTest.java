import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class BunTest {


    @Test
    public void getNameTest() {
        Bun bun = new Bun("testBun", 0);
        String expected = "testBun";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
Bun bun = new Bun("testBun", 0);
float expected = 0;
float actual = bun.getPrice();
        assertEquals(expected, actual,0.1);
    }
}
