package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    IngredientType expectedType;
    String expectedName;
    float expectedPrise;

    public IngredientTest(Ingredient ingredient, IngredientType expectedType, String expectedName, float expectedPrise) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrise = expectedPrise;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Ingredient(SAUCE,"black", 15),SAUCE, "black", 15},
                {new Ingredient(SAUCE,"red", -1),SAUCE, "red", 0},
                {new Ingredient(SAUCE,"white", 1000.1f),SAUCE, "white",0},
                {new Ingredient(SAUCE,"ok", 150),SAUCE, null,150},
                {new Ingredient(SAUCE,"blackblackblack", 0.1f),SAUCE, "blackblackblack", 0.1f},
                {new Ingredient(FILLING," red", 1000),FILLING, null, 1000},
                {new Ingredient(FILLING,"red ", 0),FILLING, null, 0},
                {new Ingredient(FILLING,"White", 999),FILLING, "White", 999},
                {new Ingredient(FILLING,"I like delicious burgers", 20),FILLING, null, 20},

        };
}
@Test
public void ingredientTest(){
   Assert.assertEquals(expectedType,ingredient.getType());
    Assert.assertEquals(expectedName,ingredient.getName());
    Assert.assertEquals(expectedPrise,ingredient.getPrice(),0.0f);

    }
}