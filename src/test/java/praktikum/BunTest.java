package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D3", 100},
                {"Краторная булка N-200i", 0},
                {"Флюоресцентная булка R2-D3", -100},
                {"", 200},
                {"!@#$%^&*()", 200},
                {null, 200},
        };
    }

    @Test
    public void getNameSuccess() {
        Bun bun = new Bun(name, price);
        assertEquals(
                name,
                bun.getName());
    }

    @Test
    public void getPriceSuccess()  {
        Bun bun = new Bun(name, price);
        assertEquals(
                price,
                bun.getPrice(), 0);
    }
}
