import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        int expected = 3;

        int actual = database.availableBuns().size();

        assertEquals(expected, actual);
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        int expected = 6;

        int actual = database.availableIngredients().size();

        assertEquals(expected, actual);
    }
}
