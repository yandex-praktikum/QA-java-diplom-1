package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {

    private final String name;

    private final float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255.2F},
                {"Булка цвета из иных миров", 2535.25F}
        };
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(name, price);
        assertEquals("Булка не отдаёт имя!", name, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Булка бесценна!", price, bun.getPrice(), 0.05);
        assertEquals("Булка бесценна!", price, bun.getPrice(), 0.05);
    }
}
