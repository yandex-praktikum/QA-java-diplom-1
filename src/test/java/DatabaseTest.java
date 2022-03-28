import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseTest {

    @Test
    public void databaseAvailableBunsGTest() {
        Database database = new Database();
        List<String> actual = new ArrayList<>();
        for (int i = database.availableBuns().size() - 1; i >= 0; i--) {
            actual.add(database.availableBuns().get(i).getName());
            actual.add(String.valueOf(database.availableBuns().get(i).getPrice()));
        }
        List<String> expected = Arrays.asList("red bun", "300.0", "white bun", "200.0", "black bun", "100.0");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void databaseAvailableIngredientsGTest() {
        Database database = new Database();
        List<String> actual = new ArrayList<>();
        for (int i = database.availableIngredients().size() - 1; i >= 0; i--) {
            actual.add(String.valueOf(database.availableIngredients().get(i).getType()));
            actual.add(database.availableIngredients().get(i).getName());
            actual.add(String.valueOf(database.availableIngredients().get(i).getPrice()));
        }
        List<String> expected = Arrays.asList("FILLING", "sausage", "300.0", "FILLING", "dinosaur", "200.0", "FILLING", "cutlet", "100.0", "SAUCE", "chili sauce", "300.0", "SAUCE", "sour cream", "200.0", "SAUCE", "hot sauce", "100.0");
        Assert.assertEquals(expected, actual);
    }
}
