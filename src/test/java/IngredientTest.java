import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;


@RunWith(Parameterized.class)
public class IngredientTest {
    IngredientType ingredientType;
    String name;
    float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {SAUCE, "лук", 24},
                {FILLING, "помидор", 43},
        };
    }

    @Test
    public void getPriceReturnFloatPositiveTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0.0f);
    }

    @Test
    public void getNameReturnStringPositiveTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getTypeReturnIngredienTypePositiveTest() {
        ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(ingredientType, actualType);
    }
}
