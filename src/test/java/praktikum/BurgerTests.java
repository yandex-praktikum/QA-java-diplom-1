package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static praktikum.helpers.Constants.*;

@RunWith(JUnitParamsRunner.class)
public class BurgerTests extends TestBase {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;

    @Test
    public void testSetBunsPropertySetsCorrectBunsToBurger() {
        //Arrange
        Burger burger = new Burger();

        //Action
        burger.setBuns(bun);

        //Assert
        Assert.assertNotNull(CHECK_IS_BUN_NULL_IN_BURGER_MESSAGE, burger.bun);
    }

    @Test
    @Parameters({
            INGREDIENT_ONE_NAME + "," + INGREDIENT_TWO_NAME
    })
    public void testAddIngredientAddsIngredientsCorrectly(String ingredientOneName, String ingredientTwoName) {
        //Arrange
        createIngredientStub(ingredientOne,ingredientOneName, null, null);
        createIngredientStub(ingredientTwo,ingredientTwoName, null, null);
        Burger burger = buildBurger(bun, ingredientOne, ingredientTwo);

        //Action
        int actualIngredientsCount = burger.ingredients.size();
        String firstBurgerIngredientName = burger.ingredients.get(0).getName();
        String secondBurgerIngredientName = burger.ingredients.get(1).getName();

        //Assert
        Assert.assertEquals(String.format(CHECK_COUNT_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE, 2, actualIngredientsCount),
                2, actualIngredientsCount);

        Assert.assertEquals(String.format(CHECK_POSITION_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE, 1,
                INGREDIENT_ONE_NAME, ingredientOneName), INGREDIENT_ONE_NAME, firstBurgerIngredientName);

        Assert.assertEquals(String.format(CHECK_POSITION_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE, 2,
                INGREDIENT_TWO_NAME, secondBurgerIngredientName), INGREDIENT_TWO_NAME, secondBurgerIngredientName);

    }

    @Test
    @Parameters({
            INGREDIENT_ONE_NAME + "," + INGREDIENT_TWO_NAME + ", 0"
    })
    public void testRemoveIngredientRemovesIngredientsCorrectly(String ingredientOneName,
                                                            String ingredientTwoName, int index) {
        //Arrange
        createIngredientStub(ingredientOne,ingredientOneName, null, null);
        createIngredientStub(ingredientTwo,ingredientTwoName, null, null);
        Burger burger = buildBurger(bun, ingredientOne, ingredientTwo);

        //Action
        burger.removeIngredient(index);
        int actualIngredientsCount = burger.ingredients.size();

        //Assert
        Assert.assertEquals(String.format(CHECK_COUNT_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE, 1, actualIngredientsCount),
                1, actualIngredientsCount);

        Assert.assertFalse(String.format(CHECK_THAT_ELEMENT_DOESNT_CONTAIN_IN_LIST_OF_INGREDIENTS_MESSAGE, ingredientOneName),
                burger.ingredients.stream().anyMatch(i -> i.getName().equals(ingredientOneName)));

        Assert.assertTrue(String.format(CHECK_THAT_ELEMENT_CONTAINS_IN_LIST_OF_INGREDIENTS_MESSAGE, ingredientTwoName),
                burger.ingredients.stream().anyMatch(i -> i.getName().equals(ingredientTwoName)));
    }

    @Test
    @Parameters({
            INGREDIENT_ONE_NAME + "," + INGREDIENT_TWO_NAME
    })
    public void testMoveIngredientMovesIngredientsCorrectly(String ingredientOneName, String ingredientTwoName) {
        //Arrange
        createIngredientStub(ingredientOne,ingredientOneName, null, null);
        createIngredientStub(ingredientTwo,ingredientTwoName, null, null);
        Burger burger = buildBurger(bun, ingredientOne, ingredientTwo);

        //Action
        burger.moveIngredient(0, 1);
        String firstBurgerIngredientName = burger.ingredients.get(0).getName();
        String secondBurgerIngredientName = burger.ingredients.get(1).getName();

        //Assert
        Assert.assertEquals(String.format(CHECK_THAT_INGREDIENT_HAS_CHANGED_POSITION_MESSAGE, 1,
                INGREDIENT_TWO_NAME, firstBurgerIngredientName), INGREDIENT_TWO_NAME, firstBurgerIngredientName);

        Assert.assertEquals(String.format(CHECK_THAT_INGREDIENT_HAS_CHANGED_POSITION_MESSAGE, 2,
                INGREDIENT_ONE_NAME, secondBurgerIngredientName), INGREDIENT_ONE_NAME, secondBurgerIngredientName);
    }

    @Test
    @Parameters({
            BUN_PRICE + "," + INGREDIENT_ONE_PRICE + "," + INGREDIENT_TWO_PRICE
    })
    public void testGetPriceReturnsCorrectBurgerPrice(float bunPrice, float ingredientOnePrice, float ingredientTwoPrice) {
        //Arrange
        createIngredientStub(ingredientOne,null, ingredientOnePrice, null);
        createIngredientStub(ingredientTwo,null, ingredientTwoPrice, null);
        createBunStub(bun, null, bunPrice);

        Burger burger = buildBurger(bun, ingredientOne, ingredientTwo);

        //Action
        float actualBurgerPrice = burger.getPrice();
        float expectedBurgerPrice = bunPrice * 2 + ingredientOnePrice + ingredientTwoPrice;

        //Assert
        Assert.assertEquals(String.format(CHECK_TOTAL_BURGER_PRICE_MESSAGE, expectedBurgerPrice, actualBurgerPrice),
                expectedBurgerPrice, actualBurgerPrice, 0.01f);

    }


    @Test
    @Parameters({
            BUN_PRICE + "," + INGREDIENT_ONE_PRICE + "," + INGREDIENT_TWO_PRICE
          + ", " + BUN_NAME + "," + INGREDIENT_ONE_NAME + "," + INGREDIENT_TWO_NAME
          + "," + INGREDIENT_ONE_TYPE_STR + "," + INGREDIENT_TWO_TYPE_STR
    })
    public void testGetReceiptReturnsCorrectBurgerReceipt(
            float bunPrice, float ingredientOnePrice, float ingredientTwoPrice,
            String bunName, String ingredientOneName, String ingredientTwoName,
            String ingredientOneType, String ingredientTwoType) {
        //Arrange
        createBunStub(bun, bunName, bunPrice);
        createIngredientStub(ingredientOne, ingredientOneName, ingredientOnePrice, ingredientOneType);
        createIngredientStub(ingredientTwo, ingredientTwoName, ingredientTwoPrice, ingredientTwoType);
        Burger burger = buildBurger(bun, ingredientOne, ingredientTwo);

        Pair<String, Float> bunPair = new Pair<>(bunName, bunPrice);
        List<Triplet<String, Float, String>> ingredients = Arrays.asList(
                new Triplet<>(ingredientOneName, ingredientOnePrice, ingredientOneType),
                new Triplet<>(ingredientTwoName, ingredientTwoPrice, ingredientTwoType));

        String expectedBurgerReceipt = buildReceipt(bunPair, ingredients);

        //Action
        String actualBurgerReceipt = burger.getReceipt();

        //Assert
        Assert.assertEquals(String.format(CHECK_BURGER_RECEIPT_MESSAGE, expectedBurgerReceipt, actualBurgerReceipt),
                expectedBurgerReceipt, actualBurgerReceipt);
    }
}
