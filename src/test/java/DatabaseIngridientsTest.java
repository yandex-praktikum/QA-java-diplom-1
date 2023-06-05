import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class DatabaseIngridientsTest {
    private final int id;
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public DatabaseIngridientsTest(int id, IngredientType ingredientType, String name, float price){
        this.id = id;
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {0, IngredientType.SAUCE, "hot sauce", 100},
                {1, IngredientType.SAUCE, "sour cream", 200},
                {2, IngredientType.SAUCE, "chili sauce", 300},
                {3, IngredientType.FILLING, "cutlet", 100},
                {4, IngredientType.FILLING, "dinosaur", 200},
                {5, IngredientType.FILLING, "sausage", 300}
        };
        return Arrays.asList(data);
    }


    @Test
    public void    availableIngridirntsReturnsCorrectValue(){
        Database database = new Database();
        Ingredient ingredient = database.availableIngredients().get(id);
        IngredientType actualingredientType = ingredient.getType();
        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Ожидался другой тип", ingredientType, actualingredientType);
        Assert.assertEquals("Ожидалось другое имя", name, actualName);
        Assert.assertEquals("Ожидалсь другая цена", price, actualPrice, 0.001);
    }
}
