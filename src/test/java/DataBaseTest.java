import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;


public class DataBaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        int expected = 3;
        assertEquals(expected, database.availableBuns().size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        int expected = 6;
        assertEquals(expected, database.availableIngredients().size());
    }
}
