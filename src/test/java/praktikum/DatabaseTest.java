package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        List<Bun> buns = database.availableBuns();
        assertThat(buns.size(), notNullValue());

    }

    @Test
    public void availableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertThat(ingredients.size(), notNullValue());
    }
}