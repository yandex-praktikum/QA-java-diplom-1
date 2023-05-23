import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {


    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals(60, 60, ingredient.getPrice());
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals("Spicy", ingredient.getName());
        //System.out.println(ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Spicy", 60);
        assertEquals(SAUCE, ingredient.getType());
    }
}