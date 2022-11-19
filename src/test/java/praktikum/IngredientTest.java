package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;

    private final String ingredientName;

    private final float ingredientPrice;

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static List<?> parametersForShouldMoveIngredients() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Терияки", 55},
                {IngredientType.FILLING, "Терияки", 55},
                {IngredientType.SAUCE, "Терияки", Float.MAX_VALUE},
                {IngredientType.SAUCE, "Терияки", Float.MIN_VALUE},
                {IngredientType.SAUCE, "Терияки", 10.000000000001f},
                {IngredientType.SAUCE, "f", 55},
                {IngredientType.SAUCE, "!№;*(?()*)%);%(?№__+", 55},
                {IngredientType.SAUCE, "очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка, очень длинная строка", 55}
        });
    }

    @Test
    public void getPrice() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(ingredientType, ingredient.getType());
    }
}