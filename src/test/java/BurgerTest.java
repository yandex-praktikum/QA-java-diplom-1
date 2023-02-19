import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends BaseBurger {


    @Test
    public void setBunsReturnRightBunsInReceipt() {
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));

        burger.setBuns(buns.get(0));

        String actualResult = burger.getReceipt();
        assertEquals(BUNS_ADDED_EXPECTED, actualResult);
    }

    @Test
    public void addIngredientReturnRightBunsInReceipt() {
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));

        String actualResult = burger.getReceipt();
        assertEquals(INGREDIENT_ADDED_EXPECTED, actualResult);
    }

    @Test
    public void removeIngredientReturnReceiptWithoutThatIngredient(){
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));


        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);

        String actualResult = burger.getReceipt();
        assertEquals(BUNS_ADDED_EXPECTED, actualResult);
    }
    @Test
    public void moveIngredientReturnReceiptWithIngredientsMoved(){
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(ingredients.get(4)).thenReturn(new Ingredient(IngredientType.FILLING, "dinosaur", 200));

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.moveIngredient(1,0);

        String actualResult = burger.getReceipt();
        assertEquals(INGREDIENT_MOVED_EXPECTED, actualResult);
    }
    @Test
    public void getPriceReturnPrice(){
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));

        float actualResult = burger.getPrice();
        assertEquals(400, actualResult, 0);
    }
    @Test
    public void getReceiptReturnsRightReceipt(){
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(ingredients.get(3)).thenReturn(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        Mockito.when(ingredients.get(4)).thenReturn(new Ingredient(IngredientType.FILLING, "dinosaur", 200));

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(4));

        String actualResult = burger.getReceipt();
        assertEquals(RECEIPT_EXPECTED,  actualResult);
    }

}