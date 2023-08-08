//Покрой тестами классы Bun, Burger, Ingredient, IngredientType
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f},

        };
    }

    @Test
    public void getNameTest() {
        bun = new Bun(name, price);
        String expected = name;
        String actual = bun.getName();
        assertEquals(expected, actual);

    }

    @Test
    public void getPriceTest() {
        bun = new Bun(name, price);
        float expected = price;
        float actual = bun.getPrice();
        float delta = 0f;
        assertEquals(expected, actual, delta);
    }

}
