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

    //Проверяем, что метод getName возвращает правильное название булки
    @Test
    public void testBunGetName() {
        Bun bun = new Bun(name, price);
        assertEquals("Безымянная булка!", name, bun.getName());
    }

    //Проверяем, что метод getPrice возвращает правильную цену булки
    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Булка бесценна!", price, bun.getPrice(), 0.005);
    }
}
