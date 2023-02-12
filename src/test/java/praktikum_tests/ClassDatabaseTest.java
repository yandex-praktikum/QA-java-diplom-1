package praktikum_tests;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ClassDatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }


    @Test
    public void checkAvailableBunsReturnsListOfBuns() {
        List<Bun> buns =  database.availableBuns();
        assertThat(buns, CoreMatchers.notNullValue());

    }

    @Test
    public void checkAvailableIngredientsReturnsListOfIngredients() {
        List<Ingredient> ingredients  =  database.availableIngredients();
        assertThat(ingredients, CoreMatchers.notNullValue());

    }
}
