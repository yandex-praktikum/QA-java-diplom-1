package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.Constant.*;

@RunWith(Parameterized.class)
public class AccordPriceBunTest {
    private final String name;
    private final float price;
    private final boolean expected;
    private static Bun bun;

    public  static boolean isActual(float price) throws Exception {
        return price == bun.getPrice(bun.getName());
    }


    public AccordPriceBunTest(String name, float price, boolean expected) {
        this.name = name;
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Name bun: {0}")
    public static Object[][] bunParamTest() {
        return new Object[][]{
                {BLACK_BUN,BLACK_PRICE, true},
                {BLACK_BUN,WHITE_PRICE, false},
        };
    }

    @Test
    public  void checkAccordPriceTest() throws Exception {
        bun = new Bun(name,price,expected);
        assertEquals(isActual(price),expected);
    }
}
