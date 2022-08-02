package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String EXPECTED_NAME = "Французская булочка";
    private final float EXPECTED_PRICE = 7.77F;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(EXPECTED_NAME, EXPECTED_PRICE);
    }

    @Test
    public void getNameOfBun() {
        String actualBunName = bun.getName();
        assertEquals("Название булочки не соответствует", actualBunName, EXPECTED_NAME);
    }

    @Test
    public void getPriceOfBun() {
        float actualBunPrice = bun.getPrice();
        assertEquals("Цена булочки не соответствует", actualBunPrice, EXPECTED_PRICE, 0);
    }
}
