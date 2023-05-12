import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

/**
 * Тесты, покрывающие класс Ingredient
 *
 * @see Ingredient
 */
@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final String expectedType;
    private final String expectedName;
    private final float expectedPrice;


    public IngredientParameterizedTest(IngredientType type, String name, float price,String expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Hot", 10.77f, "SAUCE", "Hot", 10.77f},
                {IngredientType.SAUCE, "Chili", 150.673f, "SAUCE", "Chili", 150.673f},
                {IngredientType.SAUCE, "", 0, "SAUCE", "", 0},
                {IngredientType.FILLING, "Meat", 55, "FILLING", "Meat", 55},
                {IngredientType.FILLING, "Sausage", 5.99f, "FILLING", "Sausage", 5.99f},
                {IngredientType.FILLING, "", 100.01f, "FILLING", "", 100.01f},
        };
    }

    @Test
    public void shouldBeCreateIngredients() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getType(), IngredientType.valueOf(expectedType));
        assertEquals(ingredient.getName(), expectedName);
        assertEquals(ingredient.getPrice(), expectedPrice, 0.0);
    }
}