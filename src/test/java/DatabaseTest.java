import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        int expected = 3;

        int actual = database.availableBuns().size();

        assertEquals("Количество булок не совпадает", expected, actual);
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        int expected = 6;

        int actual = database.availableIngredients().size();

        assertEquals("Количество ингредиентов не совпадает", expected, actual);
    }
}
