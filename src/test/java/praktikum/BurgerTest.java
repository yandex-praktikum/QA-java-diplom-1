package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Ingredient ingredientFilling;
    @Mock
    private Ingredient ingredientSauce;
    @Mock
    private Bun bun;

    @Before
    public void createTestObjects(){

        burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(1255f);

        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(3000f);
        Mockito.when(ingredientFilling.getName()).thenReturn("Говяжий метеорит");

        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(80f);
        Mockito.when(ingredientSauce.getName()).thenReturn("Фирменный");

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

    }


    @Test
    public void addIngredientReturnsCorrectNumberTest() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        int actualCountIngredients = burger.ingredients.size();
        int expectedCountIngredients = 4;
        assertEquals(expectedCountIngredients,actualCountIngredients);

    }

    @Test
    public void removeIngredientDeletesElementTest() {

        Ingredient removedIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        boolean isIngredientIn = burger.ingredients.contains(removedIngredient);
        assertFalse(isIngredientIn);
    }

    @Test
    public void moveIngredientReturnsCorrectOrderTest() {
        Ingredient firstIngredientBeforeMoving = burger.ingredients.get(0);
        Ingredient secondIngredientBeforeMoving = burger.ingredients.get(1);
        burger.moveIngredient(0,1);
        Ingredient firstIngredientAfterMoving = burger.ingredients.get(0);
        Ingredient secondIngredientAfterMoving = burger.ingredients.get(1);
        assertEquals(firstIngredientBeforeMoving,secondIngredientAfterMoving);
        assertEquals(secondIngredientBeforeMoving,firstIngredientAfterMoving);

    }

    @Test
    public void getPriceReturnsCorrectPriceTest() {

        float expectedPrice = 1255 * 2 + 3000 + 80;
        float actualPrice = burger.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getValidReceiptTest() {

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Краторная булка N-200i ====)" + "\r\n"+ "= sauce Фирменный ="+"\r\n"+
                "= filling Говяжий метеорит =" +"\r\n" + "(==== Краторная булка N-200i ====)"+ "\r\n"+"\r\n"+ "Price: 5590,000000" + "\r\n";

        Assert.assertEquals(actualReceipt,expectedReceipt);


    }


}