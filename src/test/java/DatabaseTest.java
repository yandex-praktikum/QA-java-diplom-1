import org.junit.Test;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        String message = "Не удалось получить доступные булочки";
        List<Bun> bunsActual = database.availableBuns();
        assertEquals(message,3, bunsActual.size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        String message = "Не удалось получить доступные ингредиенты";
        List<Ingredient> ingredientActual = database.availableIngredients();
        assertEquals(message, 6, ingredientActual.size());
    }
}
