package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.helpers.Constants;

import static praktikum.helpers.Constants.CHECK_NAME_TEST_MESSAGE;
import static praktikum.helpers.Constants.CHECK_PRICE_TEST_MESSAGE;

@RunWith(JUnitParamsRunner.class)
public class IngredientTests extends TestBase {
    @Test
    @Parameters({
            Constants.INGREDIENT_ONE_NAME
                    + "," + Constants.INGREDIENT_ONE_PRICE
                    + ", " + Constants.INGREDIENT_ONE_TYPE_STR
    })
    public void getNameReturnsCorrectIngredientNameTest(String name, float price, String ingredientType) {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.valueOf(ingredientType), name, price);

        // Action
        String ingredientName = ingredient.getName();

        // Assert
        Assert.assertEquals(String.format(CHECK_NAME_TEST_MESSAGE,
                Constants.INGREDIENT_ONE_NAME, ingredientName), Constants.INGREDIENT_ONE_NAME, ingredientName);
    }


    @Test
    @Parameters({
            Constants.INGREDIENT_ONE_NAME
                    + "," + Constants.INGREDIENT_ONE_PRICE
                    + ", " + Constants.INGREDIENT_ONE_TYPE_STR
    })
    public void getNameReturnsCorrectIngredientTypeTest(String name, float price, String ingredientType) {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.valueOf(ingredientType), name, price);

        // Action
        IngredientType actualIngredientType = ingredient.getType();

        // Assert
        Assert.assertEquals(String.format(CHECK_NAME_TEST_MESSAGE,
                        Constants.INGREDIENT_ONE_TYPE_STR, actualIngredientType.toString()),
                Constants.INGREDIENT_ONE_TYPE_STR, actualIngredientType.toString());
    }

    @Test
    @Parameters({
            Constants.INGREDIENT_ONE_NAME
                    + "," + Constants.INGREDIENT_ONE_PRICE
                    + ", " + Constants.INGREDIENT_ONE_TYPE_STR
    })
    public void getNameReturnsCorrectIngredientPriceTest(String name, float price, String ingredientType) {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.valueOf(ingredientType), name, price);

        // Action
        float ingredientPrice = ingredient.getPrice();

        // Assert
        Assert.assertEquals(String.format(CHECK_PRICE_TEST_MESSAGE,
                        Constants.INGREDIENT_ONE_PRICE, ingredientPrice),
                Constants.INGREDIENT_ONE_PRICE, ingredientPrice, 0.01f);
    }
}
