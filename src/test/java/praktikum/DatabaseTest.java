package praktikum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class DatabaseTest {


    @Test
    public void getAvailableBunsTest() {
        Database database = new Database();
        List<Bun> actualList = database.availableBuns();

        List<Bun> expectedList = new ArrayList<>(asList(
                new Bun("black bun", 100),
                new Bun("white bun", 200),
                new Bun("red bun", 300)
        ));

        assertEquals("Number of buns: " + actualList.size(), expectedList.size(), actualList.size());

        for (int i = 0; i <= 1; i++) {
            Bun actual = actualList.get(i);
            Bun expected = actualList.get(i);

            assertEquals("Name " + i + "-bun is correct", expected.getName(), actual.getName());
            assertEquals("Price " + i + "-bun is correct", expected.getPrice(), actual.getPrice(), 0);
        }
    }

    @Test
    public void getAvailableIngredientsTest() {
        Database database = new Database();
        List<Ingredient> actualList = database.availableIngredients();

        List<Ingredient> expectedList = new ArrayList<>(asList(
                new Ingredient(SAUCE, "hot sauce", 100),
                new Ingredient(SAUCE, "sour cream", 200),
                new Ingredient(SAUCE, "chili sauce", 300),

                new Ingredient(FILLING, "cutlet", 100),
                new Ingredient(FILLING, "dinosaur", 200),
                new Ingredient(FILLING, "sausage", 300)
        ));

        assertEquals("Number of ingredients: " + actualList.size(), expectedList.size(), actualList.size());

        for (int i = 0; i <= 1; i++) {
            Ingredient actual = actualList.get(i);
            Ingredient expected = actualList.get(i);

            assertEquals("Price " + i + "-ingredient is correct", expected.getPrice(), actual.getPrice(), 0);
            assertEquals("Name " + i + "-ingredient is correct", expected.getName(), actual.getName());
            assertEquals("Type " + i + "-ingredient is correct", expected.getType(), actual.getType());
        }
    }
}