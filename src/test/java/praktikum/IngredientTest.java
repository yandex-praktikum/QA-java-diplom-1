package praktikum;
import junit.framework.TestCase;
import org.junit.Test;

public class IngredientTest extends TestCase {
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals("sour cream", ingredient.getName());
    }

    public void testTestGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(200F, ingredient.getPrice());
    }

    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}