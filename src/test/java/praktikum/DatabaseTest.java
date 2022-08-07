package praktikum;
import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    @Test
    public void checkAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
    }
    @Test
    public void checkAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredient = database.availableIngredients();
        assertNotNull(ingredient);
    }


}
