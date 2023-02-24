import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    final String NAME = "Булочка";
    final float PRICE = 51015.F;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Булочка", 51015.F);
    }

    @Test
    public void checkingTheMethodGetName() {
        String expectedResult = NAME;
        String actualResult = bun.getName();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkingTheMethodGetPrice() {
        float expectedResult = PRICE;
        float actualResult = bun.getPrice();
        assertEquals(expectedResult, actualResult, 0.0F);
    }
}