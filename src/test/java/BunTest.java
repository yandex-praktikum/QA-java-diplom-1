import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {null, 0},
                {"", 1},
                {"white bread", -1},
                {"gre{*_)@}", Float.NaN},
                {"234rfew32", (float) -3E+38},
                {"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", Float.MAX_VALUE},
                {"erg", Float.MAX_VALUE + 1},
                {"ывптwerfo123ХЪ{*3%$#}", Float.MIN_VALUE}
        };
    }

    @Test
    public void checkGetNameCorrectReturn() {
        Bun bun = new Bun(name, price);
        assertEquals("Названия должны быть равны", bun.getName(), name);
    }

    @Test
    public void checkGetPriceCorrectReturn() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена должна быть равна", bun.getPrice(), price, 0);
    }
}
