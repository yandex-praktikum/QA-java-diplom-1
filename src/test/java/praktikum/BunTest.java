package praktikum;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BunTest {
    private final String NAME = "Пшеничная";
    private final Float PRICE = 1f;

    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void bunCorrectPriceReturns(){
        assertEquals(PRICE, bun.getPrice());
    }

    @Test
    public void bunCorrectNameReturns(){
        assertEquals(NAME, bun.getName());
    }
}
