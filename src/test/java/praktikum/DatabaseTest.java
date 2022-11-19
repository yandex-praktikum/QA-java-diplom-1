package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
    }

    @Test
    public void availableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
    }
}