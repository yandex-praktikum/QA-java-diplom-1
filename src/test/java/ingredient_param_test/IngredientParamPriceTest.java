package ingredient_param_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamPriceTest {
    private final float expected;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientParamPriceTest(float price, String name, IngredientType type, float expected) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Стоимомсть ингредиента: {0}, {1}, {2}, Ожидаемая цена, {3}")
    public static Object[][] checkIngredientPrice() {
        return new Object[][]{
                {100, "hot sauce", SAUCE, 100},
                {200, "sour cream", SAUCE, 200},
                {300, "chili sauce", SAUCE, 300},
                {100, "cutlet", FILLING, 100},
                {200, "dinosaur", FILLING, 200},
                {300, "sausage", FILLING, 300},
        };
    }

    @Test
    public void checkIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.0);
    }
}
