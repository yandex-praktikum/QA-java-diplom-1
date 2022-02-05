package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    @Test
    public void getPriceReturnIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Star Dust", 20);
        assertEquals(20, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnIngredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Star Dust", 20);
        assertEquals("Star Dust", ingredient.getName());
    }

    @Test
    public void getTypeRetutnIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Star Dust", 20);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}