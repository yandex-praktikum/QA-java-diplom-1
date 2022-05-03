package praktikum.database;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

public class DataBaseTests {
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient;

    @Test
    public void getAvailableBunsTest() {
        Database testDatabase = new Database();
        testDatabase.availableBuns().add(testBun);
        Assert.assertTrue(testDatabase.availableBuns().contains(testBun));

    }

    @Test
    public void getAvailableIngredientsTest() {
        Database testDatabase = new Database();
        testDatabase.availableIngredients().add(testIngredient);
        Assert.assertTrue(testDatabase.availableIngredients().contains(testIngredient));
    }
}
