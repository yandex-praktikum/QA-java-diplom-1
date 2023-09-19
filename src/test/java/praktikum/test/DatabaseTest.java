package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@RunWith(Parameterized.class)
public class DatabaseTest {

    private List<Bun> expectedBuns;
    private List<Ingredient> expectedIngredients;
    private Database database;

    public DatabaseTest(List<Bun> expectedBuns, List<Ingredient> expectedIngredients) {
        this.expectedBuns = expectedBuns;
        this.expectedIngredients = expectedIngredients;
    }
    @Before
    public void setUp() {
        database = new Database();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Bun> expectedBuns = new ArrayList<>();
        expectedBuns.add(new Bun("black bun", 100));
        expectedBuns.add(new Bun("white bun", 200));
        expectedBuns.add(new Bun("red bun", 300));

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        return Arrays.asList(new Object[][] {
                {expectedBuns, expectedIngredients}
        });
    }

    @Test
    public void testDatabaseAvailableBuns() {
        List<Bun> actualBuns = database.availableBuns();
        assertNotNull(actualBuns);
        assertEquals(expectedBuns.size(), actualBuns.size());
    }
    @Test
    public void testDatabaseChangeBuns() {
        List<Bun> actualBuns = database.availableBuns();

        for (int i = 0; i < expectedBuns.size(); i++) {
            Bun expectedBun = expectedBuns.get(i);
            Bun actualBun = actualBuns.get(i);
            assertEquals(expectedBun.getName(), actualBun.getName());
            assertEquals(expectedBun.getPrice(), actualBun.getPrice(), 0.01);
        }
    }

    @Test
    public void testDatabaseAvailableIngredients() {
        List<Ingredient> actualIngredients = database.availableIngredients();
        assertNotNull(actualIngredients);
        assertEquals(expectedIngredients.size(), actualIngredients.size());
    }
    @Test
    public void testDatabaseChangeIngredients() {
        List<Ingredient> actualIngredients = database.availableIngredients();

        for (int i = 0; i < expectedIngredients.size(); i++) {
            Ingredient expectedIngredient = expectedIngredients.get(i);
            Ingredient actualIngredient = actualIngredients.get(i);
            assertEquals(expectedIngredient.getName(), actualIngredient.getName());
            assertEquals(expectedIngredient.getType(), actualIngredient.getType());
            assertEquals(expectedIngredient.getPrice(), actualIngredient.getPrice(), 0.01);
        }
    }
}