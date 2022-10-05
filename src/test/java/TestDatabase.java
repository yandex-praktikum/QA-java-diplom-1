import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class TestDatabase {
    private List<Bun> createBuns() {
        List<Bun> buns = new ArrayList<>();

        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        return buns;
    }
    private List<Ingredient> createIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        return ingredients;
    }

    Database database = new Database();

    @Test
    public void checkDatabaseAvailableBuns() {
        for(int i = 0; i < createBuns().size(); i++) {
            Assert.assertEquals(createBuns().get(i).getName(), database.availableBuns().get(i).getName());
            Assert.assertEquals(createBuns().get(i).getPrice(), database.availableBuns().get(i).getPrice(), 0);
        }
    }

    @Test
    public void checkDatabaseAvailableIngredients() {
        for(int i = 0; i < createIngredients().size(); i++) {
            Assert.assertEquals(createIngredients().get(i).getType(), database.availableIngredients().get(i).getType());
            Assert.assertEquals(createIngredients().get(i).getName(), database.availableIngredients().get(i).getName());
            Assert.assertEquals(createIngredients().get(i).getPrice(), database.availableIngredients().get(i).getPrice(), 0);
        }
    }
}
