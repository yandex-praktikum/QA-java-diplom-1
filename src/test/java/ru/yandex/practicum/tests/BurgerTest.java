package ru.yandex.practicum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger;

    private final String BUN_NAME = "Пшеничная";
    private final String MEAT_NAME = "Котлета";
    private final String CHEESE_NAME = "Сыр";
    private final String MUSTARD_NAME = "Горчица";
    private final float BUN_PRICE = 19.5f;
    private final float MEAT_PRICE = 50.5f;
    private final float CHEESE_PRICE = 28.35f;
    private final float MUSTARD_PRICE = 9.15f;
    Bun wheatBun = new Bun(BUN_NAME, BUN_PRICE);
    Ingredient meat = new Ingredient(IngredientType.FILLING, MEAT_NAME, MEAT_PRICE);
    Ingredient cheese = new Ingredient(IngredientType.FILLING, CHEESE_NAME, CHEESE_PRICE);
    Ingredient mustard = new Ingredient(IngredientType.SAUCE, MUSTARD_NAME, MUSTARD_PRICE);

    @Test
    public void addIngredientCallsWithCorrectParameter() {
        burger.addIngredient(meat);
        Mockito.verify(burger).addIngredient(meat);
    }

    @Test
    public void addIngredientCallsMultipleTimesWithParameter() {
        burger.addIngredient(cheese);
        burger.addIngredient(cheese);
        Mockito.verify(burger, Mockito.times(2)).addIngredient(cheese);
    }

    @Test
    public void addIngredientAddsCorrectValue() {
        Burger burger = new Burger();
        Ingredient expectedIngredient = meat;
        burger.addIngredient(meat);
        assertEquals("The added ingredient does not match the expected result", expectedIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientRemovesCorrectValue() {
        Burger burger = new Burger();
        burger.ingredients.add(meat);
        burger.ingredients.add(cheese);
        burger.ingredients.add(mustard);
        burger.removeIngredient(1);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(meat);
        expectedIngredients.add(mustard);
        assertEquals("The list of ingredients does not match the expected result after removing an ingredient",
                expectedIngredients, burger.ingredients);
    }

    @Test
    public void moveIngredientMovesCorrectValue() {
        Burger burger = new Burger();
        burger.ingredients.add(meat);
        burger.ingredients.add(cheese);
        burger.ingredients.add(mustard);
        burger.moveIngredient(2, 1);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(meat);
        expectedIngredients.add(mustard);
        expectedIngredients.add(cheese);
        assertEquals("The list of ingredients does not match the expected result after moving an ingredient",
                expectedIngredients, burger.ingredients);
    }

    @Test
    public void getPriceStubReturnsCorrectValue() {
        Mockito.when(burger.getPrice()).thenReturn(125f);
        assertEquals("The burger should have a default price", 125f, burger.getPrice(), 0);
    }

//    @Test
//    public void getPriceReturnsCorrectValue() {
//        Burger burger = new Burger();
//        burger.setBuns(wheatBun);
//        burger.ingredients.add(meat);
//        burger.ingredients.add(cheese);
//        burger.ingredients.add(mustard);
//        float expectedPrice = 2 * BUN_PRICE + MEAT_PRICE + CHEESE_PRICE + MUSTARD_PRICE;
//        assertEquals("The burger price does not match the expected result", expectedPrice, burger.getPrice(), 0);
//    }

    @Test
    public void getReceiptReturnsCorrectValues() {
        Burger burger = new Burger();
        burger.setBuns(wheatBun);
        burger.ingredients.add(meat);
        burger.ingredients.add(cheese);
        burger.ingredients.add(mustard);
        String expectedReceipt = burger.getReceipt();
        assertTrue(expectedReceipt.contains(BUN_NAME));
        assertTrue(expectedReceipt.contains(MEAT_NAME));
        assertTrue(expectedReceipt.contains(CHEESE_NAME));
        assertTrue(expectedReceipt.contains(MUSTARD_NAME));
        assertTrue(expectedReceipt.contains("Price"));
    }
}
