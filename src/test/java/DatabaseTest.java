import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {
    @Test
    public void availableBunsTest(){
        Database database = new Database();
        List<Bun> actualBuns = database.availableBuns();
        List<Bun> expectedBuns = new ArrayList<>();

        expectedBuns.add(new Bun("black bun", 100));
        expectedBuns.add(new Bun("white bun", 200));
        expectedBuns.add(new Bun("red bun", 300));

        for (int i = 0; i < expectedBuns.size(); i++) {
            Assert.assertEquals("Wrong bun's name",expectedBuns.get(i).getName(),actualBuns.get(i).getName());
            Assert.assertEquals("Wrong bun's price",expectedBuns.get(i).getPrice(),actualBuns.get(i).getPrice(),0);
        }
    }
    @Test
    public void availableIngredientsTest(){
        Database database = new Database();
        List<Ingredient> actualIngredients = database.availableIngredients();
        List<Ingredient> expectedIngredients = new ArrayList<>();

        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        expectedIngredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        expectedIngredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));

        for (int i = 0; i < expectedIngredients.size(); i++) {
            Assert.assertEquals("Wrong ingredient's name",expectedIngredients.get(i).getName(),actualIngredients.get(i).getName());
            Assert.assertEquals("Wrong ingredient's type",expectedIngredients.get(i).getType(),actualIngredients.get(i).getType());
            Assert.assertEquals("Wrong ingredient's price",expectedIngredients.get(i).getPrice(),actualIngredients.get(i).getPrice(),0);
        }
    }
}
