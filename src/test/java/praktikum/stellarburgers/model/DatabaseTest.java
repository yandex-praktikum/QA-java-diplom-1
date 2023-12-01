package praktikum.stellarburgers.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    private Database database;

    @Before
    public void initDatabase() {
        database = new Database();
    }

    @Test
    public void availableBuns() { Assert.assertFalse(database.availableBuns().isEmpty()); }

    @Test
    public void availableIngredients() {
        Assert.assertFalse(database.availableIngredients().isEmpty());
    }
}
