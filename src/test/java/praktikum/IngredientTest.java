package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getIngredientsTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Булочка", (float) 1.22);
        String expectedName = "Булочка";
        float expectedPrice = (float) 1.22;

        assertEquals(expectedName, ingredient.getName());
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0f);

    }

}