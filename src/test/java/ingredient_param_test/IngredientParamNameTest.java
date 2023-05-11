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
public class IngredientParamNameTest {
    private final String expected;
    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientParamNameTest(float price, String name, IngredientType type, String expected) {
        this.price = price;
        this.name = name;
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Наименование ингредиента: {0}, {1}, {2}, Ожидаемое наименование, {3}")
    public static Object[][] checkIngredientName() {
        return new Object[][]{
                {100, "hot sauce", SAUCE, "hot sauce"},
                {200, "sour cream", SAUCE, "sour cream"},
                {300, "chili sauce", SAUCE, "chili sauce"},
                {100, "cutlet", FILLING, "cutlet"},
                {200, "dinosaur", FILLING, "dinosaur"},
                {300, "sausage", FILLING, "sausage"},
        };
    }

    @Test
    public void checkIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
}
