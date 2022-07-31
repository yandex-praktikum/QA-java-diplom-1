package praktikum;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private static final String INCORRECT_TYPE_MESSAGE = "Тип ингредиента указан не правильно";

    private final Ingredient ingredient;
    private final IngredientType expectedType;

    public IngredientTypeTest(Ingredient ingredient, IngredientType expectedType) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "{index}: тип ингридиента {1}")
    public static Object[][] genData() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "Жгучий", 10f), IngredientType.SAUCE},
                {new Ingredient(IngredientType.FILLING, "Бекон", 10f), IngredientType.FILLING},
                {new Ingredient(null, "", 0f), null}
        };
    }

    @Test
    @Description("Проверяем различные варианты ингредиентов")
    public void testIngredientType() {
        IngredientType actualType = ingredient.getType();
        assertEquals(INCORRECT_TYPE_MESSAGE, expectedType, actualType);
        System.out.println(actualType);
    }
}