package praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }


    @Test
    public void checkAvailableBunsReturnsListOfBuns() {
        List<Bun> buns =  database.availableBuns();
        assertNotNull("The method availableBuns returns list of buns which is not empty",buns);

    }

    @Test
    public void checkAvailableIngredientsReturnsListOfIngredients() {
        List<Ingredient> ingredients  =  database.availableIngredients();
       assertNotNull("The method availableIngredients returns list of ingredients which is not empty",ingredients);

    }
}
