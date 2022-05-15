import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp(){
        database = new Database();
    }

    @Test
    public void testBuns() {
        Assert.assertEquals("Buns not 3", 3, database.availableBuns().size());
    }

    @Test
    public void testIngredients() {
        Assert.assertEquals("Ingrediets are not 6", 6, database.availableIngredients().size());
    }
}
