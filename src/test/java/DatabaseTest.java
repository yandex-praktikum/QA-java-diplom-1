import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

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
        assertThat("Список булок не может быть пустым", buns.size(), notNullValue());

    }

    @Test
    public void availableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertThat("Список ингредиентов не может быть пустым", ingredients.size(), notNullValue());
    }
}