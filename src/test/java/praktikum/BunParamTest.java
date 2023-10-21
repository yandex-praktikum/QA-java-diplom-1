package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.Constant.*;
import static praktikum.Message.*;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String name;
    private final float price;
    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Name bun: {0}")
    public static Object[][] bunParamTest() {
        return new Object[][]{
                {BLACK_BUN,BLACK_PRICE},
                {WHITE_BUN,WHITE_PRICE},
                {RED_BUN,RED_PRICE}
        };
    }

    @Test
    public  void checkBunParamTest(){
        var bun = new Bun(name,price);
        assertEquals(WRONG_NAME_MSG, name,bun.getName());
        assertEquals(WRONG_PRICE_MSG, price,bun.getPrice(),DELTA);
    }

}
