package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertFalse;


public class DatabaseTest  {

    private final Database db = new Database();

    @Test
    public void availableBunsTest() {
        assertFalse(db.availableBuns().isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        assertFalse(db.availableIngredients().isEmpty());
    }
}