package praktikum;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {

    private Ingredient ingredient;
    private String name;
    private float price;

    @Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][] {
                {IngredientType.SAUCE, "barbeque", 0.01f, IngredientType.SAUCE},
                {IngredientType.FILLING, "barbeque", 0.01f, IngredientType.FILLING},
        };
    }

    @Test
    @Parameters(method = "getIngredientTypes")
    public void getIngredientTypeReturnsCorrectValue(IngredientType ingredientType, String name, float price,
                                                     IngredientType expectedIngredientType) {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        Assert.assertEquals(expectedIngredientType, ingredient.getType());
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "barbeque", 0.01f);
    }

    @Test
    public void getIngredientNameReturnsCorrectValue() {
        String expectedName = "barbeque";

        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getIngredientPriceReturnsCorrectValue() {
        float expectedPrice = 0.01f;

        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @After
    public void tearDown() {
        ingredient = null;
    }
}
