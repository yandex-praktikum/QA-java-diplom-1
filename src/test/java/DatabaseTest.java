import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class DatabaseTest {

    @Test
    public void availableBunsDatabaseTest() {
        Database database = new Database();
        Bun bunBlack = new Bun("black bun", 100);
        Bun bunWhite = new Bun("white bun", 200);
        Bun bunRed = new Bun("red bun", 300);
        List<Bun> buns = new ArrayList<>(Arrays.asList(bunBlack, bunWhite, bunRed));
        Assert.assertEquals(buns.size(), database.availableBuns().size());
        for (int i = 0; i < buns.size(); i++) {
            Assert.assertEquals(buns.get(i).getName(), database.availableBuns().get(i).getName());
            Assert.assertEquals(buns.get(i).getPrice(), database.availableBuns().get(i).getPrice(), 0);
        }
    }

    @Test
    public void availableIngredientsDatabaseTest() {
        Database database = new Database();
        Ingredient ingredientHotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredientSourCream = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredientChiliSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient ingredientCutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredientDinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        Ingredient ingredientSausage = new Ingredient(IngredientType.FILLING, "sausage", 300);
        List<Ingredient> ingredients = new ArrayList<>(Arrays.asList(
                ingredientHotSauce, ingredientSourCream,
                ingredientChiliSauce, ingredientCutlet,
                ingredientDinosaur, ingredientSausage));
        Assert.assertEquals(ingredients.size(), database.availableIngredients().size());
        for (int i = 0; i < ingredients.size(); i++) {
            Assert.assertEquals(ingredients.get(i).getName(), database.availableIngredients().get(i).getName());
            Assert.assertEquals(ingredients.get(i).getPrice(), database.availableIngredients().get(i).getPrice(), 0);
            Assert.assertEquals(ingredients.get(i).getType(), database.availableIngredients().get(i).getType());
        }
    }
}

