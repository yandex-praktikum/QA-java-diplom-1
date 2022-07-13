package praktikum;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    private static Database database;

    @BeforeClass
    public static void beforeClass() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        assertTrue(database.availableBuns()
                .containsAll(List.of(new Bun("black bun", 100),
                        new Bun("white bun", 200),
                        new Bun("red bun", 300))));
    }

    @Test
    public void availableIngredients() {
        assertTrue(database.availableIngredients()
                .containsAll(List.of(new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                        new Ingredient(IngredientType.FILLING, "cutlet", 100),
                        new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                        new Ingredient(IngredientType.FILLING, "sausage", 300))));
    }

    @Test
    public void addBun() {
        Database database = new Database();
        Bun bun = new Bun("white bun", 200);
        assertTrue(database.addBun(bun));
    }

    @Test
    public void addIngredient() {
        Database database = new Database();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertTrue(database.addIngredient(ingredient));
    }
}