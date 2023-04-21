package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {
    Database database = new Database();
    @Test
    public void availableBunsTest() {
        Assert.assertEquals(3, database.availableBuns().size());
    }
    @Test
    public void availableIngredientsTest() {
        Assert.assertEquals(6, database.availableIngredients().size());
    }
}
