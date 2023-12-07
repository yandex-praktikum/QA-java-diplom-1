package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    private Database database;

    @Before
    public void setup() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        Assert.assertEquals("Кол-во булочек некорректное", 3, database.availableBuns().size());
    }

    @Test
    public void availableIngredients() {
        Assert.assertEquals("Кол-во ингредиентов некорректное", 6, database.availableIngredients().size());
    }
}