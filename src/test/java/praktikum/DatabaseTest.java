package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    @Mock
    private final List<Bun> buns = new ArrayList<>();

    @Mock
    private final List<Ingredient> ingredients = new ArrayList<>();


    @Test
    public void databaseAvailableReturnBunsAndIngredients() {
        Database database = new Database();
        buns.add(new Bun("black bun", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        assertNotNull(database.availableBuns());
        assertNotNull(database.availableIngredients());


    }
}
