

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

public class GetAvailableIngredientsTest {
    @Mock
    Ingredient ingredient;

    @Test
    public void getAvailableIngredients(){
        Database database = new Database();
        database.availableIngredients().add(ingredient);
        Assert.assertTrue(database.availableIngredients().contains(ingredient));
    }
}