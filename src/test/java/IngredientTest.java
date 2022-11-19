import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 100);
        String actual = ingredient.getName();
        assertEquals("chili sauce", actual);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        float actual = ingredient.getPrice();
        assertEquals(200f, actual, 0.0f);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200);
        IngredientType actual = ingredient.getType();
        assertEquals(FILLING, actual);
    }
}
