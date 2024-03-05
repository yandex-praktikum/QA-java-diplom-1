import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Chicken", 10.0f);
        assertEquals(10.0f, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Carrot", 2.5f);
        assertEquals("Carrot", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Salt", 1.0f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
