package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;
import static praktikum.testConstants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    private Burger burger;

    @Before
    public void startUp(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientsTest(){
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getBurgerPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);

        Assert.assertEquals(BURGER_SUM_PRICE, burger.getPrice(), 0.0);
    }

    @Test
    public void getBurgerReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        when(bun.getName()).thenReturn(BUN_FOR_BURGER);
        when(firstIngredient.getName()).thenReturn(SAUCE_FOR_BURGER);
        when(secondIngredient.getName()).thenReturn(FILLING_FOR_BURGER);
        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
        when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);

        Assert.assertEquals(EXPECTED_RECEIPT, burger.getReceipt());
    }
}