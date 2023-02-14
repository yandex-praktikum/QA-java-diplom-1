package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private final float price;
    private final String name;

    public BunTest(String name, float price) {
        this.price = price;
        this.name = name;
    }


    @Parameterized.Parameters
    public static Object[][] bunsParam() {
        return new Object[][]{
                {"", 0},
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void shouldGetNameReturnName() {
        bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void shouldGetPriceReturnPrice() {
        bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}