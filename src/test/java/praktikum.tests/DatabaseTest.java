package praktikum.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }
    @Test
    public void availableBunsNotEmptyTest(){
        List<Bun> availableBuns = database.availableBuns();
        Assert.assertFalse(availableBuns.isEmpty());
    }
    @Test
    public void availableIngredientsNotEmptyTest(){
        List<Ingredient> availableIngredients = database.availableIngredients();
        Assert.assertFalse(availableIngredients.isEmpty());
    }
}
