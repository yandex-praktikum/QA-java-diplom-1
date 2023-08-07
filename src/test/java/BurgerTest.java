
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;


    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Bun hasn't been set",bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "www", 100);
        burger.addIngredient(ingredient);
        int expected = 1;
        int actual = burger.ingredients.size();
        Assert.assertEquals("Ingredient hasn't been added", expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "www", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expected = 0;
        int actual = burger.ingredients.size();
        Assert.assertEquals("List should be empty", expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(SAUCE, "www", 100);
        Ingredient ingredient2 = new Ingredient(SAUCE, "www", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Ingredient expected = ingredient2;
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Incorrect order of ingredients", expected, actual);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float expected = 500;
        float actual = burger.getPrice();
        assertEquals("Incorrect price", expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.getPrice();

        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Incorrect receipt", expectedReceipt, actualReceipt);
    }

}
