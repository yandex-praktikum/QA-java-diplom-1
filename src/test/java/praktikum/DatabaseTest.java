package praktikum;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertFalse;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();

        List<Bun> actual = database.availableBuns();

        assertFalse(actual.isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();

        List<Ingredient> actual = database.availableIngredients();

        assertFalse(actual.isEmpty());
    }
}
