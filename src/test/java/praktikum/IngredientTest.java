package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType ingredientType;
    private String name;
    private float price;


    public IngredientTest( IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static Object [][] createIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE,"Кисло-сладкий", 150.50f},
                {IngredientType.FILLING,"Сыр", 50.25f},
                {IngredientType.SAUCE,null, 150.50f},
                {IngredientType.SAUCE,"Сырный", 150},
        };
    }

    @Test
    public void constructorIngredientTest() {

        Ingredient ingredient = new Ingredient(ingredientType,name,price);

        Assert.assertNotNull(ingredient);
        Assert.assertEquals(ingredientType,ingredient.type);
        Assert.assertEquals(name,ingredient.name);
        Assert.assertEquals(price,ingredient.price,0.00f);
    }
}
