package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    IngredientType type = IngredientType.SAUCE;
    String ingredientName = "secret ingredient";
    float ingredientPrice = 199;

    Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);


    @Test
    public void testIngredientGetPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals("wrong ingredient's price", ingredientPrice, actualPrice, 0);
    }

    @Test
    public void testIngredientGetName() {
        String actualName = ingredient.getName();
        assertEquals("wrong ingredient's name",ingredientName, actualName);
    }

    @Test
    public void testIngredientGetType() {
        IngredientType actualType = ingredient.getType();
        assertEquals("wrong ingredient's type", type, actualType);
    }
}