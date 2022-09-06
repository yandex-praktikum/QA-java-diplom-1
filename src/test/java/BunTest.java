import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String burgerName = "Superburger";
    private final float burgerPrice = 300;

    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun(burgerName, burgerPrice);
        String expected = burgerName;

        String actual = bun.getName();

        assertEquals("Returns incorrect burger name", expected, actual);
    }

    @Test
    public void getPriceReturnsPrice() {
        Bun bun = new Bun(burgerName, burgerPrice);
        float expected = burgerPrice;

        float actual = bun.getPrice();

        assertEquals("Returns incorrect price", expected, actual, 0);
    }
}
