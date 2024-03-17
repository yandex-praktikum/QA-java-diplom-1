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
    private float delta = TestData.DELTA;
    private static final String BUN_NAME = TestData.returnRandomBunName();
    private static final String INGREDIENT_NAME = TestData.returnRandomIngredientName();
    private static final String INGREDIENT_TWO_NAME = TestData.returnRandomIngredientName();
    private static final String INGREDIENT_THREE_NAME = TestData.returnRandomIngredientName();
    private static final float BUN_PRICE = TestData.returnRandomPrice();
    private static final float INGREDIENT_PRICE = TestData.returnRandomPrice();
    private static final IngredientType INGREDIENT_TYPE = TestData.returnRandomIngredientType();
    private static final IngredientType INGREDIENT_TYPE_TWO = TestData.returnRandomIngredientType();
    private static final IngredientType INGREDIENT_TYPE_THREE = TestData.returnRandomIngredientType();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientTwo;

    @Mock
    Ingredient ingredientThree;

    @Mock
    Burger burgerMock;


    @Test
    public void setBunTest() {
        burgerMock.setBuns(bun);
        Mockito.verify(burgerMock).setBuns(bun);
    }

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient);
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(INGREDIENT_TYPE);
        Assert.assertTrue("Ingredient name should be returned in the receipt",
                burger.getReceipt().contains(INGREDIENT_NAME));
        Assert.assertTrue("Ingredient type should be in the receipt",
                burger.getReceipt().contains(INGREDIENT_TYPE.toString().toLowerCase()));
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient, ingredientTwo);
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        Mockito.when(ingredientTwo.getName()).thenReturn(INGREDIENT_TWO_NAME);
        Mockito.when(ingredientTwo.getType()).thenReturn(INGREDIENT_TYPE_TWO);
        burger.removeIngredient(0);
        Assert.assertFalse("First ingredient shouldn't be in the receipt",
                burger.getReceipt().contains(INGREDIENT_NAME));
        Assert.assertTrue("Second ingredient should be in the receipt",
                burger.getReceipt().contains(INGREDIENT_TWO_NAME));
    }

    @Test
    public void getPriceTest() {
        List<Ingredient> ingredientsList = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo);
        burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredientsList);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(INGREDIENT_PRICE);
        float expectedTotalPrice = MethodsHelpers.returnBurgerTotalPrice(bun, ingredientsList);
        Assert.assertEquals("Prices should be equal", expectedTotalPrice, burger.getPrice(), delta);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo, ingredientThree);
        int index = TestData.generateIndex(ingredients);
        int newIndex = TestData.generateIndex(index, ingredients);
        burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredients);
        burger.moveIngredient(index, newIndex);
        ingredients.add(newIndex, ingredients.remove(index));
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(ingredientTwo.getName()).thenReturn(INGREDIENT_TWO_NAME);
        Mockito.when(ingredientTwo.getType()).thenReturn(INGREDIENT_TYPE_TWO);
        Mockito.when(ingredientThree.getName()).thenReturn(INGREDIENT_THREE_NAME);
        Mockito.when(ingredientThree.getType()).thenReturn(INGREDIENT_TYPE_THREE);
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
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(ingredientThree.getName()).thenReturn(INGREDIENT_THREE_NAME);
        Mockito.when(ingredientThree.getType()).thenReturn(INGREDIENT_TYPE_TWO);
        String receipt = burger.getReceipt();
        String expectedReceipt = MethodsHelpers.getExpectedReceipt(bun, ingredients);
        Assert.assertEquals("Receipt and expectedReceipt should have the same ingredients and be equal",
                expectedReceipt, receipt);
    }
}
