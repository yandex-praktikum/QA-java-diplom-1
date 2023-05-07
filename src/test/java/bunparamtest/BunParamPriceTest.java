package bunparamtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunParamPriceTest {
    private final float expected;
    private final  String name;
    private final float price;
    public  BunParamPriceTest(float expected, float price, String name) {
        this.expected = expected;
        this.price = price;
        this.name = name;
    }
    @Parameterized.Parameters
    public static Object[][] checkPrice() {
        return new Object[][]{
                {100,100,"black bun"},
                {200,200,"white bun"},
                {300,300,"red bun"},
        };
    }
    @Test
    public void checkPriceTest() {
        Bun bun = new Bun(name,price);
        float actual =  bun.getPrice();
        assertEquals(expected, actual,0.0);
    }
}
