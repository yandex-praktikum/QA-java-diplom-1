package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    Database database = new Database();

    @Test
    public void availableBunsCheck() {
        List<Bun> actual = database.availableBuns();
        assertNotNull(actual);
    }

    @Test
    public void availableIngredientsCheck() {
        List<Ingredient> actual = database.availableIngredients();
        assertNotNull(actual);
    }
}
