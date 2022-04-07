import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)

public class BurgerMockTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;


    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(1337F);
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);
        float actualBurgerPrice = bun.getPrice() * 2 + ingredient.getPrice();
        Assert.assertEquals("Цена бургера не совпадает с ожидаемым значением", actualBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(bun.getPrice()).thenReturn(1337F);
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()))
                .append(String.format("(==== %s ====)%n", bun.getName())).append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals("Рецепт бургера не совпадает с ожидаемым значением", receipt.toString(), burger.getReceipt());
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun bunBurger = new Bun("black bun", 1337F);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(1337F);
        burger.setBuns(bunBurger);
        Assert.assertEquals("Название бургера совпадает", bun.getName(), burger.bun.name);
        Assert.assertEquals("Цена бургера совпадает", bun.getPrice(), burger.bun.price, 0);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredientBurger = new Ingredient(SAUCE, "hot sauce", 1337F);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(1337F);
        burger.addIngredient(ingredientBurger);
        Assert.assertEquals("Тип ингредиента совпадает", ingredient.getType(), burger.ingredients.get(0).type);
        Assert.assertEquals("Название ингредиента совпадает", ingredient.getName(), burger.ingredients.get(0).name);
        Assert.assertEquals("Цена ингредиента совпадает", ingredient.getPrice(), burger.ingredients.get(0).price, 0);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredientBurger = new Ingredient(SAUCE, "hot sauce", 1337F);
        burger.addIngredient(ingredientBurger);
        Ingredient removeIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(removeIngredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredientBurgerFirst = new Ingredient(SAUCE, "hot sauce", 1337F);
        Ingredient ingredientBurgerSecond = new Ingredient(FILLING, "test sauce", 137F);
        burger.addIngredient(ingredientBurgerFirst);
        burger.addIngredient(ingredientBurgerSecond);

        Ingredient moveIngredient = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredient = burger.ingredients.get(1);
        assertEquals(moveIngredient, actualIngredient);
    }
}

