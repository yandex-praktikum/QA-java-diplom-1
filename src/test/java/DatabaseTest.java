import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import javax.xml.crypto.Data;

public class DatabaseTest {

    @Test
    public void testBunsInDatabaseConstructor(){
        Database database = new Database();
        int expectedBunsCount = 3;
        int actual = database.availableBuns().size();
        String message = "Database создан с неожиданным количеством булочек";
        Assert.assertEquals(message, expectedBunsCount, actual);
    }

    @Test
    public void testIngredientsInDatabaseConstructor(){
        Database database = new Database();
        int expectedIngredientsCount = 6;
        int actual = database.availableIngredients().size();
        String message = "Database создан с неожиданным количеством ингредиентов";
        Assert.assertEquals(message, expectedIngredientsCount, actual);
    }
}
