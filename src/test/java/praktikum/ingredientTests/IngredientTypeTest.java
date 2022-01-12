package praktikum.ingredientTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, "name", 18);
        Assert.assertEquals(ingredient.getType(), ingredient.type);
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }
}