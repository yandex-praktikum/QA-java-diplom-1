import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    @Test
    public void getListOfBuns() {
        Database database = new Database();
        int sizeListOfBuns = database.availableBuns().size();
        assertEquals(sizeListOfBuns,3);
    }

    @Test
    public void getListOfIngredients() {
        Database database = new Database();
        int sizeListOfIngredients = database.availableIngredients().size();
        assertEquals(sizeListOfIngredients,6);
    }
}
