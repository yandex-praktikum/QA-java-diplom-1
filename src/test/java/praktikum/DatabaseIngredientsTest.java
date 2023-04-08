package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DatabaseIngredientsTest {
    Database base = new Database();
    public IngredientType type;
    public String name;
    public float price;
    public int index;

    public DatabaseIngredientsTest(int index, IngredientType type, String name, float price) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
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
    public void availableIngredientsTest() {
        Ingredient ingredient = base.availableIngredients().get(index);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }
}
