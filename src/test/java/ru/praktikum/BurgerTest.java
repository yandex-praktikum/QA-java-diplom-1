package ru.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;
    Burger burger;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @After
    public void tearDown(){
        burger.bun = null;
        burger.ingredients.clear();
    }


    @Test
    public void setBunsWritesData(){
        burger.setBuns(bun);
        Assert.assertNotNull("Bun not included", burger.bun);
    }

    @Test
    public void addIngredientAddsAnIngredient(){
        burger.addIngredient(ingredientOne);
        int actualSize = burger.ingredients.size();
        int expectedSize = 1;
        Assert.assertEquals("Ingredient not added", expectedSize, actualSize);
    }

    @Test
    public void removeIngredientRemovesAnIngredient(){
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        int expectedSize = 0;
        Assert.assertEquals("Ingredient not removed", expectedSize, actualSize);
    }

    @Test
    public void moveIngredientMovesIngredient(){
        Mockito.when(ingredientTwo.getName()).thenReturn("Ingredient number two");
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0,1);
        String actualName = burger.ingredients.get(0).getName();
        String expectedName = "Ingredient number two";
        Assert.assertEquals("Incorrect movement of the ingredient", expectedName, actualName);
    }

    @Test
    public void getPriceReturnCorrectPrice(){
        Mockito.when(bun.getPrice()).thenReturn(150.5f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(200.5f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(300.5f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        float actualPrice = burger.getPrice();
        float expectedPrice = 802.0f;
        Assert.assertEquals("Incorrect price", expectedPrice, actualPrice, 0);

    }

    @Test
    public void getReceiptReturnsCorrectReceipt(){
        Mockito.when(bun.getName()).thenReturn("potato");
        Mockito.when(ingredientOne.getName()).thenReturn("cutlet");
        Mockito.when(ingredientTwo.getName()).thenReturn("cheesy");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(150.5f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(200.5f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(300.5f);
        float expectedPrice = 802.000000f;
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        String actualReceipt = burger.getReceipt();
        String nameBun = String.format("(==== %s ====)%n", bun.getName());
        String nameIngredientOne = String.format("= %s %s =%n", ingredientOne.getType().toString().toLowerCase(), ingredientOne.getName());
        String nameIngredientTwo = String.format("= %s %s =%n", ingredientTwo.getType().toString().toLowerCase(), ingredientTwo.getName());
        String priceBurger = String.format("%nPrice: %f%n", expectedPrice);
        String expectedReceipt = nameBun + nameIngredientOne + nameIngredientTwo + nameBun + priceBurger;
        Assert.assertEquals("Incorrect receipt", expectedReceipt, actualReceipt);



    }



}
