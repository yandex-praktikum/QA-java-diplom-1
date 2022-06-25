package praktikum;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void checkAvailableListOfBuns(){
        Database database = new Database();
        List<Bun> currentListOfBuns = database.availableBuns();
        assertNotNull(currentListOfBuns);
    }

    @Test
    public void checkAvailableListOfIngredients(){
        Database database = new Database();
        List<Ingredient> currentListOfIngredients = database.availableIngredients();
        assertNotNull(currentListOfIngredients);
    }

}