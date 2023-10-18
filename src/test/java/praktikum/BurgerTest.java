package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;
import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsSuccess() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredientSuccess() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientSuccess() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(INGREDIENT_INDEX);
        Mockito.verify(burger).removeIngredient(INGREDIENT_INDEX);
    }

    @Test
    public void moveIngredientSuccess() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(INGREDIENT_INDEX, NEW_INGREDIENT_INDEX);
        Mockito.verify(burger).moveIngredient(INGREDIENT_INDEX, NEW_INGREDIENT_INDEX);
    }

    @Test
    public void getPriceSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(FILLING_PRICE);
        float burgerPrice = (BUN_PRICE * 2 + FILLING_PRICE);
        Assert.assertTrue(Math.abs(burger.getPrice()- burgerPrice) <= 0.00001);
    }

    @Test
    public void getReceiptSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn(FILLING_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(FILLING_PRICE);
        Assert.assertEquals(
                RECEIPT,
                burger.getReceipt());

    }

}
