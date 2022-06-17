package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DatabaseTest {

    private Database database;

    @Before
    public void setup() {
        database = new Database();
    }

    @Test
    public void availableBunsReturnsCorrectValues() {

        List<Bun> expectedBuns = Arrays.asList(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        );

        List<Bun> actualBuns = database.availableBuns();
        Assert.assertEquals(expectedBuns, actualBuns);
    }

    @Test
    public void availableIngredientsReturnsCorrectValues() {
        List<Ingredient> expectedIngredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                new Ingredient(IngredientType.FILLING, "cutlet", 100),
                new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                new Ingredient(IngredientType.FILLING, "sausage", 300)
        );

        List<Ingredient> actualIngredients = database.availableIngredients();
        Assert.assertEquals(expectedIngredients, actualIngredients);
    }

    @After
    public void tearDown() {
        database = null;
    }
}