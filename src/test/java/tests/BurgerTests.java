package tests;

import helpers.MethodsHelpers;
import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Ingredient ingredient = TestData.returnIngredientByIndex(2);
    Ingredient ingredientTwo = TestData.returnIngredientByIndex(5);
    Ingredient ingredientThree = TestData.returnIngredientByIndex(4);

    @Mock
    Bun bunMock;

    @Test
    public void setBunTest() {
        Bun bun = TestData.returnRandomBun();
        Burger burger = new Burger();
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        Assert.assertTrue("Bun's name should be in receipt", receipt.contains(bun.getName()));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = MethodsHelpers.addIngredientsToIngredientList(ingredient);
        MethodsHelpers.setBurgerBunAndIngredients(burger, bunMock,
                ingredients);
        String receipt = burger.getReceipt();
        Assert.assertTrue("Ingredient's name should be in receipt", receipt.contains(ingredient.getName()));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        String receipt = burger.getReceipt();
        Assert.assertFalse("Ingredient shouldn't be in receipt",
                receipt.contains(ingredient.getName()));
    }

    @Test
    public void getPriceTest() {
        Bun bun = TestData.returnRandomBun();
        List<Ingredient> ingredientsList = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo);
        Burger burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bun, ingredientsList);
        float expectedPrice = MethodsHelpers.returnBurgerTotalPrice(bun, ingredientsList);
        float actualPrice = burger.getPrice();
        Assert.assertEquals("Prices should match", expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void moveIngredientsTest() {
        List<Ingredient> ingredientsList = MethodsHelpers.addIngredientsToIngredientList(ingredient,
                ingredientTwo, ingredientThree);
        int  index = TestData.generateIndex(ingredientsList);
        int newIndex = TestData.generateIndex(index, ingredientsList);
        Burger burger = new Burger();
        MethodsHelpers.setBurgerBunAndIngredients(burger, bunMock, ingredientsList);
        burger.moveIngredient(index, newIndex);
        ingredientsList.add(newIndex, ingredientsList.remove(index));
        String receipt = burger.getReceipt();
        String expectedReceipt = MethodsHelpers.getExpectedReceipt(bunMock, ingredientsList);
        Assert.assertEquals("Receipt and expectedReceipt should have the same ingredients order and be equal",
                expectedReceipt, receipt);
    }

    @Test
    public void getReceiptTest() {
    }
}
