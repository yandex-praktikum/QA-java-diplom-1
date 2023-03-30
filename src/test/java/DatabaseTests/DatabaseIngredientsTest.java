package DatabaseTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class DatabaseIngredientsTest {

    private final int index;
    private final IngredientType ingredientType;
    private final String name;
    private final int price;

    public DatabaseIngredientsTest(int index, IngredientType ingredientType, String name, int price) {
        this.index = index;
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, IngredientType.SAUCE, "hot sauce", 100},
                {1, IngredientType.SAUCE, "sour cream", 200},
                {2, IngredientType.SAUCE, "chili sauce", 300},
                {3, IngredientType.FILLING, "cutlet", 100},
                {4, IngredientType.FILLING, "dinosaur", 200},
                {5, IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void availableIngredientsReturnCorrectList() {
        Database database = new Database();
        Assert.assertEquals(ingredientType, database.availableIngredients().get(index).getType());
        Assert.assertEquals(name, database.availableIngredients().get(index).getName());
        Assert.assertEquals(price, database.availableIngredients().get(index).getPrice(), 0);
    }
}
