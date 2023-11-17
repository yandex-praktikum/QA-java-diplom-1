package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void checkBunsCount() {
        Assert.assertEquals("Количество булочек не совпадает", 3, database.availableBuns().size());
    }

    @Test
    public void checkIngredientsCount() {
        Assert.assertEquals("Количество ингредиентов не совпадает", 6, database.availableIngredients().size());
    }
}
