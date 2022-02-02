import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void shouldBeAvailableBuns(){

        Database database = new Database();
       List<Bun> actualListOfBuns =  database.availableBuns();
        assertNotNull(actualListOfBuns);

    }

    @Test
    public void shouldBeAvailableIngredients(){

        Database database = new Database();
        List<Ingredient> actualListOfIngredients =  database.availableIngredients();
        assertNotNull(actualListOfIngredients);

    }

}
