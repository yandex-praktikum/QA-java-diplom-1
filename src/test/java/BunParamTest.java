import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {

    private final String name;
    private final float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAndPrice() {
        return new Object[][]{
                {null, 0},
                {"", Float.MIN_VALUE},
                {"ОченьДлинноеНазваниеОченьДлинноеНазваниеОчень" +
                        "ДлинноеНазваниеОченьДлинноеНазвание", -Float.MAX_VALUE},
                {"#&&^$??#@*", Float.MAX_VALUE},
                {"б", 40f},
                {"Buter Брод", 3f}
        };
    }

    @Test
    public void getNameReturnCorrectName() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getName(), name);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getPrice(), price, 0);
    }

}

