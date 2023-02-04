import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{0},{1},{2}")
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Beef", 1},
                {IngredientType.SAUCE, "Tomato", 300},
                {IngredientType.FILLING, null, 1.0f},
                {IngredientType.FILLING, "Apple", 0},
                {IngredientType.FILLING, "Bread", 0.5f}
        };
    }

    @Test
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
