package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Burger burger;

    @Test
    public void getRealPrice() {
        when(bun.getPrice()).thenReturn(1F);
        when(ingredient.getPrice()).thenReturn(2F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Float actual = burger.getPrice();
        Float expected = 4F;
        assertEquals("Ошибка в расчетах", expected, actual);
    }

    @Test
    public void getRealReceipt() {
        when(bun.getName()).thenReturn("Булочка для бургера");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("Котлета");
        when(burger.getPrice()).thenReturn(0f);
        String bunName = bun.getName();
        String ingredientType = ingredient.getType().toString().toLowerCase(Locale.ROOT);
        String ingredientName = ingredient.getName();
        float burgerPrice = burger.getPrice();

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actual = burger.getReceipt();
        String expected = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                bunName, ingredientType, ingredientName, bunName, burgerPrice);

        assertEquals("Это другой бургер", expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(Arrays.asList(ingredient, ingredient));
        burger.removeIngredient(0);

        int expected = 1;
        int actual = burger.ingredients.size();

        assertEquals("Ингредиент не был удален", expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(Arrays.asList(mock(Ingredient.class), mock(Ingredient.class)));

        List<Ingredient> beforeMove = new ArrayList<>(burger.ingredients);
        burger.moveIngredient(1, 0);
        List<Ingredient> afterMove = burger.ingredients;

        Iterator<Ingredient> beforeMoveIterator = beforeMove.listIterator();
        Iterator<Ingredient> afterMoveIterator = afterMove.listIterator();

        while (beforeMoveIterator.hasNext()) {
            Assert.assertNotEquals(afterMoveIterator.next(), beforeMoveIterator.next());
        }
    }

}
