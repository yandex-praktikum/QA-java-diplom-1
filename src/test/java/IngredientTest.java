import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 10);

    @Test
    public void checkCanGetIngredientType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void checkErrorWhenIncorrectIngredientType() {
        assertNotEquals(IngredientType.FILLING, ingredient.getType());
    }
    @Test
    public void checkCanGetIngredientName() {
        assertEquals("sauce", ingredient.getName());
    }
    @Test
    public void checkErrorWhenIncorrectName() {
        assertNotEquals("filling", ingredient.getName());
    }
    @Test
    public void checkCanGetPrice() {
        assertEquals(10, ingredient.getPrice(), 0);
    }
    @Test
    public void checkErrorWhenIncorrectPrice() {
        assertNotEquals(20, ingredient.getPrice(), 0);
    }
}
