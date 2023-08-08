import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


public class IngridientTest {

   Ingredient ingredient;

    @Test

    public void getPriceTest() {
        ingredient = new Ingredient(SAUCE, "sour cream", 200f);
        float expected = 200f;
        float actual = ingredient.getPrice();
        float delta = 0f;
        assertEquals(expected, actual, delta);

    }
    @Test
    public void getNameTest() {
        ingredient = new Ingredient(FILLING, "dinosaur", 200f);
        String expected = "dinosaur";
        String actual = ingredient.getName();
       assertEquals(expected, actual);

    }

    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(FILLING, "sausage", 100f);
        IngredientType expected = FILLING;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);

    }

}
