package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
public class DatabaseTest {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();
    private Database database;

    @Before
    public void init() {
        database = new Database();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        ingredients.add(new Ingredient(SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(FILLING, "sausage", 300));
    }

    @Test
    public void checkAvailableBuns() {
        assertSame(buns.getClass(), database.availableBuns().getClass());
    }

    @Test
    public void checkAvailableIngredients() {
        assertSame(ingredients.getClass(), database.availableIngredients().getClass());
    }
}