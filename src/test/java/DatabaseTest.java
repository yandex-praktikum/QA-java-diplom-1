import org.junit.Test;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();

        List<Bun> bunsActual = database.availableBuns();
        assertEquals(3, bunsActual.size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        List<Ingredient> ingredientActual = database.availableIngredients();
        assertEquals(6, ingredientActual.size());
    }
}
