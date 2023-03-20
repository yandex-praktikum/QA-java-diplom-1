import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class IngredientTest {
    @Mock
    IngredientType ingredientType;
    private final String name = "dinosaur";
    private final float price = 100;
    Ingredient ingredient = new Ingredient(ingredientType, name, price);

    @Test
    public void getNameIngredient() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceIngredient() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeIngredient() {
        assertNull(ingredient.getType());
    }
}
