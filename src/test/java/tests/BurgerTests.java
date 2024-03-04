package tests;

import helpers.MethodsHelpers;
import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    private Burger burger;
    private static final String bunName = TestData.returnRandomBunName();
    private static final String ingredientName = TestData.returnRandomIngredientName();
    private static final String ingredientTwoName = TestData.returnRandomIngredientName();
    private static final String ingredientThreeName = TestData.returnRandomIngredientName();
    private static final float bunPrice = TestData.returnRandomPrice();
    private static final float ingredientPrice = TestData.returnRandomPrice();
    private static final IngredientType ingredientType = TestData.returnRandomIngredientType();
    private static final IngredientType ingredientTypeTwo = TestData.returnRandomIngredientType();
    private static final IngredientType ingredientTypeThree = TestData.returnRandomIngredientType();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientTwo;

    @Mock
    Ingredient ingredientThree;


    @Test
    public void setBunTest() {
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Assert.assertTrue("Bun name should be returned in the receipt", burger.getReceipt().contains(bunName));
    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient);
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertTrue("Ingredient name should be returned in the receipt",
                burger.getReceipt().contains(ingredientName));
        Assert.assertTrue("Ingredient type should be in the receipt",
                burger.getReceipt().contains(ingredientType.toString().toLowerCase()));
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient, ingredientTwo);
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        Mockito.when(ingredientTwo.getName()).thenReturn(ingredientTwoName);
        Mockito.when(ingredientTwo.getType()).thenReturn(ingredientTypeTwo);
        burger.removeIngredient(0);
        Assert.assertFalse("First ingredient shouldn't be in the receipt",
                burger.getReceipt().contains(ingredientName));
        Assert.assertTrue("Second ingredient should be in the receipt",
                burger.getReceipt().contains(ingredientTwoName));
    }

    @Test
    public void getPriceTest() {
        List<Ingredient> ingredientsList = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo);
        burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredientsList);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(ingredientPrice);
        float expectedTotalPrice = MethodsHelpers.returnBurgerTotalPrice(bun, ingredientsList);
        Assert.assertEquals("Prices should be equal", expectedTotalPrice, burger.getPrice(), 0.00f);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo, ingredientThree);
        int  index = TestData.generateIndex(ingredients);
        int newIndex = TestData.generateIndex(index, ingredients);
        burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        burger.moveIngredient(index, newIndex);
        ingredients.add(newIndex, ingredients.remove(index));
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredientTwo.getName()).thenReturn(ingredientTwoName);
        Mockito.when(ingredientTwo.getType()).thenReturn(ingredientTypeTwo);
        Mockito.when(ingredientThree.getName()).thenReturn(ingredientThreeName);
        Mockito.when(ingredientThree.getType()).thenReturn(ingredientTypeThree);
        String receipt = burger.getReceipt();
        String expectedReceipt = MethodsHelpers.getExpectedReceipt(bun, ingredients);
        Assert.assertEquals("Receipt and expectedReceipt should have the same ingredients order and be equal",
                expectedReceipt, receipt);
    }

    @Test
    public void getReceiptTest() {
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient, ingredientThree);
        burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredientThree.getName()).thenReturn(ingredientThreeName);
        Mockito.when(ingredientThree.getType()).thenReturn(ingredientTypeTwo);
        String receipt = burger.getReceipt();
        String expectedReceipt = MethodsHelpers.getExpectedReceipt(bun, ingredients);
        Assert.assertEquals("Receipt and expectedReceipt should have the same ingredients and be equal",
                expectedReceipt, receipt);
    }
}
