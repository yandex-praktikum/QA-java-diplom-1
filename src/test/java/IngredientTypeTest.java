import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


public class IngredientTypeTest {
    Ingredient ingredient;
    Ingredient ingredient1;

    @Test
    public void ingredientTypeTest() {
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
        ingredient1 = new Ingredient(FILLING, "cutlet", 100);

        IngredientType expectedType = SAUCE;
        IngredientType expectedType1 = FILLING;
        IngredientType actualType = ingredient.getType();
        IngredientType actualType1 = ingredient1.getType();
        assertEquals(expectedType, actualType);
        assertEquals(expectedType1, actualType1);
    }

}
