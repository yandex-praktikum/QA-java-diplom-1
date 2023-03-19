package praktikum.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class DatabaseSauceTest {

    private IngredientType type;
    private String name;
    private float price;

    public DatabaseSauceTest(IngredientType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
    }

    @Test
    public void check() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Ingredient expectedIngredient = new Ingredient(type, name, price);
        assertTrue(hasIngredient(ingredients, expectedIngredient));
    }

    private boolean hasIngredient(List<Ingredient> ingredients, Ingredient neededIngredient) {
        for (Ingredient ingredient : ingredients) {
            if (neededIngredient.getType().equals(ingredient.getType())
                    && neededIngredient.getName().equals(ingredient.getName())
                    && neededIngredient.getPrice() == ingredient.getPrice())
                return true;
        }
        return false;
    }
}
