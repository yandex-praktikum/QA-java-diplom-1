import praktikum.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;
    private final String name;
    private final float price;

    public BurgerParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void createReceipt() {
        sauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        filling = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "{index} : price = {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"black", 100},
                {"white", 200}
        };
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();

        assertEquals("Burger price is incorrect", expected, actual, 0);
    }
}
