import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    @Mock
    IngredientType ingredientType;

    @Test
    public void getTypeTest() {
        assertEquals(ingredient.getType(), IngredientType.FILLING);
    }

    @Test
    public void getNameTest() {
        assertEquals(ingredient.getName(), "cutlet");
    }

    @Test
    public void getPriceTest() {
        assertEquals(ingredient.getPrice(), 100, 1);
    }
}
