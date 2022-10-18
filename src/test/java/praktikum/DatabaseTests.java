package praktikum;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTests {

    Database database = new Database();
    private List<Bun> testBuns = database.availableBuns();
    private List<Ingredient> testIngredients = database.availableIngredients();

    @Test
    public void testDatabaseFilled() {
        assertNotNull(testBuns);
        assertNotNull(testIngredients);
        assertEquals(3, testBuns.size());
        assertEquals(6, testIngredients.size());
    }

}
