import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBunsContainsExpectedValues() {
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
        assertEquals(3, buns.size());
        assertTrue(buns.stream().anyMatch(bun -> "black bun".equals(bun.getName()) && bun.getPrice() == 100));
    }

    @Test
    public void testAvailableIngredientsContainsExpectedValues() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
        assertEquals(6, ingredients.size());
        assertTrue(ingredients.stream().anyMatch(ingredient -> "hot sauce".equals(ingredient.getName()) && ingredient.getPrice() == 100 && ingredient.getType() == IngredientType.SAUCE));
    }
}
