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
public class IngredientParamTypeTest {
    private final IngredientType expected;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientParamTypeTest(IngredientType type, float price, String name, IngredientType expected) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Тип ингредиента: {0}, {1}, {2}, Ожидаемый тип, {3}")
    public static Object[][] checkIngredientType() {
        return new Object[][]{
                {SAUCE, 100, "hot sauce", SAUCE},
                {SAUCE, 200, "sour cream", SAUCE},
                {SAUCE, 300, "chili sauce", SAUCE},
                {FILLING, 100, "cutlet", FILLING},
                {FILLING, 200, "dinosaur", FILLING},
                {FILLING, 300, "sausage", FILLING},
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
