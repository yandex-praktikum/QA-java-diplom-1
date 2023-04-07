package praktikumtests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;
import java.util.stream.Collectors;

public class DatasaseTest {

    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsTest() {
       List<String> names = database.availableBuns().stream().map(Bun::getName).collect(Collectors.toList());
        Assert.assertTrue(names.contains("black bun"));
    }

    @Test
    public void availableIngredients(){
        List<String> ingredientsName = database.availableIngredients().stream()
                .map(Ingredient::getName).collect(Collectors.toList());
        Assert.assertTrue(ingredientsName.contains("chili sauce"));

    }
}
