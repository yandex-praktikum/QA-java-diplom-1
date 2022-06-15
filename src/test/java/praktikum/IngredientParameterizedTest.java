package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType ingredientTypeExpected;
    private final String nameExpected;
    private final float priceExpected;


    public IngredientParameterizedTest(IngredientType ingredientType, String name, float price) {
        this.ingredientTypeExpected = ingredientType;
        this.nameExpected = name;
        this.priceExpected = price;
    }

    @Parameterized.Parameters
    public static Object[][] createIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Кисло-сладкий", 150.50f},
                {IngredientType.FILLING, "Сыр", 50.25f},
                {IngredientType.SAUCE, "sour cream", 150},
                {IngredientType.FILLING, "cutlet", 0},
        };
    }

    @Test
    public void constructorIngredientTest() {

        Ingredient ingredient = new Ingredient(ingredientTypeExpected, nameExpected, priceExpected);

        Assert.assertNotNull("Объект пустой", ingredient);
        Assert.assertEquals("Фактическое значение типа ингредиента отличается от ожидаемого", ingredientTypeExpected, ingredient.type);
        Assert.assertEquals("Фактическое значение названия отличается от ожидаемого", nameExpected, ingredient.name);
        Assert.assertEquals("Фактическое значение цены отличается от ожидаемого", priceExpected, ingredient.price, 0.00f);
    }
}
