import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void createIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, "test ingredient name", 13.37f);
    }
    @Test
    public void shouldGetPrice() {
        assertEquals(13.37f, ingredient.getPrice(), 0);
    }
    @Test
    public void shouldGetName() {
        assertEquals("test ingredient name", ingredient.getName());
    }
    @Test
    public void shouldGetType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
