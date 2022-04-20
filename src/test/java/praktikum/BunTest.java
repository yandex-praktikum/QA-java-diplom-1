package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private final static String NAME = "black bun";
    private final static float PRICE = 4.4f;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(NAME, PRICE);

        String actual = bun.getName();

        assertEquals(NAME, actual);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(NAME, PRICE);

        float actual = bun.getPrice();

        assertEquals(0, Float.compare(PRICE, actual));
    }
}
