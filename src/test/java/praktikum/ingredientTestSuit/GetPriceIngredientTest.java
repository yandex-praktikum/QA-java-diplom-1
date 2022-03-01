package praktikum.ingredientTestSuit;

import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class GetPriceIngredientTest {
    @Test
    public void ingredientGetNameTest() {
        float price = 420;
        Ingredient testIngredient = new Ingredient(SAUCE, "Szechuan Sauce", price);
        assertEquals(price, testIngredient.getPrice(), 0);
    }
}