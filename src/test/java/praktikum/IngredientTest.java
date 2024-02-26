package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] generateTestData() {
        return new Object[][]{
                {IngredientType.FILLING, "Beef", 50f},
                {IngredientType.SAUCE, "Mayonnaise", 1f},
        };
    }

    @Test
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals("Wrong type", ingredientType, ingredient.getType());
        assertEquals("Wrong name", name, ingredient.getName());
        assertEquals("Wrong price", price, ingredient.getPrice(), 0);
    }
}