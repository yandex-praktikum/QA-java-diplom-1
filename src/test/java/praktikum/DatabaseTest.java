package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void availableBuns() {
        Database database = new Database();
        List<Bun>buns=database.availableBuns();
        Assert.assertFalse(buns.isEmpty());
    }

    @Test
    public void availableIngredients() {
        Database database = new Database();
        List<Ingredient>ingredients=database.availableIngredients();
        Assert.assertFalse(ingredients.isEmpty());
    }
}