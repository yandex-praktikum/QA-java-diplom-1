import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;


public class DatabaseTest {

    @Test
    public void checkAvailableBuns() {
        assertEquals(3, new Database().availableBuns().size());
    }

    @Test
    public void checkAvailableIngredients() {
        assertEquals(6, new Database().availableIngredients().size());
    }

}
