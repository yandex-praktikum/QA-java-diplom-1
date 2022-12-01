import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);

        assertEquals("Name is incorrect", "hot sauce", ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100);

        assertEquals("Price is incorrect", 100, ingredient.getPrice(), Float.NaN);
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(SAUCE, "sour cream", 200);

        assertEquals("Type is incorrect", SAUCE, ingredient.getType());
    }
}
