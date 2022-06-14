import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(JUnitParamsRunner.class)
public class TestDataBase {


    Database database = new Database();


    @Test
    @Parameters({"SAUCE, hot sauce, 100",
            "SAUCE, sour cream, 200",
            "SAUCE, chili sauce, 300",
            "FILLING, cutlet, 100",
            "FILLING, dinosaur, 200",
            "FILLING, sausage, 300"})
    public void checkAvailableIngredients(IngredientType ingredientType, String name, float price) {
        int count = 0;
        Ingredient expectedIngredient = new Ingredient(ingredientType, name, price);
        for (int i = 0; i < database.availableIngredients().size(); i++) {
            System.out.println(expectedIngredient.getName() + " " + database.availableIngredients().get(i).getName());
            if (expectedIngredient.getName().equals(database.availableIngredients().get(i).getName())) {
                count += 1;
                Assert.assertEquals(expectedIngredient.getName(), database.availableIngredients().get(i).getName());
                Assert.assertEquals(expectedIngredient.getType(), database.availableIngredients().get(i).getType());
                Assert.assertEquals(expectedIngredient.getPrice(), database.availableIngredients().get(i).getPrice(), 0.01F);
            }
        }
        Assert.assertEquals(1, count);
    }

    @Test
    @Parameters({"black bun, 100",
            "white bun, 200",
            "red bun, 300"})
    public void checkAvailableBuns(String name, float price) {
        Bun expectedBun = new Bun(name, price);
        int count = 0;
        for (int i = 0; i < database.availableBuns().size(); i++) {
            if (expectedBun.getName().equals(database.availableBuns().get(i).getName())) {
                count += 1;
                Assert.assertEquals(expectedBun.getName(), database.availableBuns().get(i).getName());
                Assert.assertEquals(expectedBun.getPrice(), database.availableBuns().get(i).getPrice(), 0.01F);
            }
        }
        Assert.assertEquals(1, count);
    }
}
