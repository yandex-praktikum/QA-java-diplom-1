package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static praktikum.Constant.*;
import static praktikum.Message.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
Burger burger;

    @Before
    public  void newBurger(){
        burger = new Burger();
    }

    @Mock
    Bun bun;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);

    @Test
    public void checkSetBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(BLACK_BUN);
        Assert.assertEquals(WRONG_NAME_MSG,BLACK_BUN, bun.getName());
        Mockito.verify(bun, Mockito.times(1)).getName();
    }
    @Test
    public void addOneIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals(WRONG_COUNT_ING_MSG, 1, burger.ingredients.size());
    }

    @Test
    public void addTwoIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(WRONG_COUNT_ING_MSG, 2, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredientTest(){
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue(ERROR_DELETE_MSG, burger.ingredients.isEmpty());
    }
    @Test
    public void checkRemoveOneOfIngredientTest(){
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        int sizeListIngredient = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(ERROR_DELETE_MSG,(sizeListIngredient-1), burger.ingredients.size());
    }
    @Test
    public void checkMoveIngredientTest(){
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        assertEquals(ERROR_MOVE_ING_MSG, "secondIngredient", burger.ingredients.get(0).toString());
    }

    @Test
    public void checkGetPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BLACK_PRICE);
        assertEquals(WRONG_PRICE_MSG, burger.getPrice(), bun.getPrice()*2, DELTA);
        Mockito.verify(bun, Mockito.times(2)).getPrice();
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BLACK_PRICE);
        Mockito.when(bun.getName()).thenReturn(BLACK_BUN);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(HOT_SAUCE);
        Mockito.when(firstIngredient.getPrice()).thenReturn(HOT_SAUCE_PRICE);
        burger.addIngredient(firstIngredient);
        String expected =
                String.format("(==== %s ====)%n", BLACK_BUN) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), HOT_SAUCE) +
                        String.format("(==== %s ====)%n", BLACK_BUN) +
                        String.format("%nPrice: %f%n", (BLACK_PRICE * 2 + HOT_SAUCE_PRICE));
        assertEquals(ERROR_RECEIPT_MSG, expected, burger.getReceipt());
        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }
}
