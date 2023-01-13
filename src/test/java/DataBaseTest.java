import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.*;

public class DataBaseTest {

    @Test
    public void checkAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
    }

    @Test
    public void checkAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredient = database.availableIngredients();
        assertNotNull(ingredient);
    }
}