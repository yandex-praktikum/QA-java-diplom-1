package praktikum.ingredientTestSuit;

import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class GetNameIngredientTest {
    @Test
    public void ingredientGetNameTest() {
        String name = "Szechuan Sauce";
        Ingredient testIngredient = new Ingredient(SAUCE, name, 420);
        assertEquals(name, testIngredient.getName());
    }
}
