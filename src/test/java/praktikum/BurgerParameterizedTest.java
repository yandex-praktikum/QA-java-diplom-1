package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final String name;
    private final float price;
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;

    public BurgerParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index} : price = {1}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"original-free", 0.0f},
                {"original", 200.0f}
        };
    }

    @Before
    public void setUp() {
        sauce = new Ingredient(IngredientType.SAUCE, "chili", 20.0f);
        filling = new Ingredient(IngredientType.FILLING, "cheese", 15.5f);
        burger = new Burger();
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.getPrice() + filling.getPrice();
        float actual = burger.getPrice();
        assertEquals("Стоимость бургера неверно посчитана",expected, actual, 0);
    }
}
