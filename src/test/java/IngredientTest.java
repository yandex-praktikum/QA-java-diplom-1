import org.junit.Test;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientConstructor() {
        Database database = new Database();

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(0);

        assertNotNull(ingredient);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("hot sauce", ingredient.getName());
        assertEquals(100, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetPrice() {
        Database database = new Database();

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(3);

        assertEquals(100, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Database database = new Database();

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(1);

        assertEquals("sour cream", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Database database = new Database();

        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient ingredient = ingredients.get(4);

        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
