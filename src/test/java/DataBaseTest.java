import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DataBaseTest {
    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void checkAvailableBun() {
        List<Bun> bun = database.availableBuns();
        Assert.assertFalse(bun.isEmpty());
    }

    @Test
    public void checkAvailableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertFalse(ingredients.isEmpty());
    }
}
