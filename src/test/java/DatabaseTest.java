import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> availableBuns = database.availableBuns();
        assertNotNull(availableBuns);
        assertEquals(3, availableBuns.size());
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> availableIngredients = database.availableIngredients();
        assertNotNull(availableIngredients);
        assertEquals(6, availableIngredients.size());
    }

}