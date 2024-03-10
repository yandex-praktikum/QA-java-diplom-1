package Paket;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void checkAddIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        int expected = 1;
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void checkGetPrice(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(300.00F);
        float expected= 500;
        assertEquals(expected, burger.getPrice());
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("newBun");
        Mockito.when(bun.getPrice()).thenReturn(200.00F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("newFilling");
        Mockito.when(ingredient.getPrice()).thenReturn(800.00F);
        String expected = "(==== newBun ====)\n= filling newFilling =\n(==== newBun ====)\n\nPrice: 1200,000000\n";
        assertEquals(expected, burger.getReceipt());
    }

}
