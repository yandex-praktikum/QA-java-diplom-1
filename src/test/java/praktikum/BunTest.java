package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class BunTest {
    @Test
    public void getName() {
        String bunName = "testBunName";
        float bunPrice = 10F;
        Bun bun = new Bun(bunName, bunPrice);
        String expected = bunName;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getPricePositiveTest() {
        String bunName = "testBunName";
        float bunPrice = 10F;
        Bun bun = new Bun(bunName, bunPrice);
        float expected = bunPrice;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 1.0);
    }

    @Test
    public void getPriceNullNegativeTest() {
        assertThrows(NullPointerException.class,
                ()->{
                    String bunName = "testBunName";
                    Float bunPrice = null;
                    Bun bun = new Bun(bunName, bunPrice);
                    bun.getPrice();
                });
    }

}