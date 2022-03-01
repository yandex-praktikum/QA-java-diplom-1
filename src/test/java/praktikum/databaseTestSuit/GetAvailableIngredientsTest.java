package praktikum.databaseTestSuit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Database;
import praktikum.Ingredient;

public class GetAvailableIngredientsTest {
    @Mock
    Ingredient testIngredient;

    @Test
    public void getAvailableIngredientsTest() {
        Database testDatabase = new Database();
        testDatabase.availableIngredients().add(testIngredient);
        Assert.assertTrue(testDatabase.availableIngredients().contains(testIngredient));
    }

}
