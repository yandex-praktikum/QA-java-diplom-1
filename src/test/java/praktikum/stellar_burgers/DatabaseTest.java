package praktikum.stellar_burgers;

import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertFalse;

public class DatabaseTest {

    @Test
    public void initDatabaseTest() {
        Database database = new Database();
        assertFalse(database.availableBuns().isEmpty());
        assertFalse(database.availableIngredients().isEmpty());
    }
}
