package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void createNewInstance() {
        bun = new Bun("black bun", 100.1f);
    }

    @Test
    public void initializeBunCheckNameTrue() {
        String actual = bun.getName();
        String expected = "black bun";
        assertEquals(expected, actual);
    }

    @Test
    public void initializeBunWithFloatCheckPriceTrue() {
        float actual = bun.getPrice();
        float expected = 100.1f;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void initializeBunWithIntegerCheckPriceFalse() {
        float actual = bun.getPrice();
        float expected = 100.1f;
        assertEquals(expected, actual, 0);
    }
}
