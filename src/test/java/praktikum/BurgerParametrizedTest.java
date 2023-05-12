package praktikum;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;
    private String name;
    private float price;

    public BurgerParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void createNewInstance() {
        sauce = new Ingredient(IngredientType.SAUCE, "chili", 20.0f);
        filling = new Ingredient(IngredientType.FILLING, "cheese", 15.5f);
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "{index} : price = {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"Мясо бессмертных моллюсков Protostomia", 1337.0f},
                {"Филе Люминесцентного тетраодонтимформа", 988.0f}
        };
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected;
        expected = bun.price * 2 + sauce.price + filling.price;

        float actual;
        actual = burger.getPrice();

        assertEquals("Проверка значения возваращаеой суммы", expected, actual, 0);
    }
}