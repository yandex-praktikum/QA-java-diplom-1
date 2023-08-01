package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка названия и цены булочки. Тестовые данные: {0}, {1}")
    public static Object[] getParameters() {
        return new Object[][]{
                {"Булочка с кунжутом", 50},
                {"Black bun", -1},
                {null, Float.MAX_VALUE},
                {" ", Float.MIN_VALUE},
        };
    }

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());

    }

    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
