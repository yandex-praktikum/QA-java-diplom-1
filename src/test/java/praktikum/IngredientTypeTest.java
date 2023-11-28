package praktikum;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private IngredientType ingredientType;
    private IngredientType expectedIngredientType;
    private String ingredientName = "cutlet";

    private float ingredientPrice = 10;


    public IngredientTypeTest(IngredientType ingredientType, IngredientType expectedIngredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING}
        };
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        Assert.assertEquals(expectedIngredientType, ingredient.getType());
    }
}
