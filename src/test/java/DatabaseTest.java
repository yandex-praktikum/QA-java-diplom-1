import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void availableBunsReturnCorrectCount() {
        List<Bun> response = database.availableBuns();
        Assert.assertEquals(response.size(), 3);
    }

    @Test
    public void availableIngredientsReturnCorrectCount() {
        List<Ingredient> response = database.availableIngredients();
        Assert.assertEquals(response.size(), 6);
    }
}
