import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    private String ingredientName = "tastyOnion";
    private float ingredientPrice = 18.52f;

    @Mock
    IngredientType type;

    @Test
    public void getNameShouldReturnName() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceShouldReturnPrice() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.0);
    }
}
