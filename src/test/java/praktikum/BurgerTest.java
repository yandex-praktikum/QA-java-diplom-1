package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;
    @Mock
    Ingredient ingredientThree;

    @BeforeEach
    public void beforeTest() {
        burger = new Burger();
    }

    @Test
    public void setBunsForBurgerBunAdded() {
        Mockito.when(bun.getName()).thenReturn("Bun#1");
        burger.setBuns(bun);
        assertEquals(burger.bun.getName(), "Bun#1", "Bun is not set for burger");
    }

    @Test
    public void addIngredientsToBurgerIngredientAdded() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        assertEquals(burger.ingredients.size(), 2, "Ingredient was not added to burger");
    }

    @Test
    public void removeIngredientFromBurgerWithExistedIndexIngredientRemoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.removeIngredient(1);
        assertEquals(burger.ingredients.size(), 1, "Ingredient was not removed from burger");
    }

    @Test
    public void removeIngredientWithNotExistedIndexExceptionThrown() {
        burger.addIngredient(ingredientOne);
        assertThrows(IndexOutOfBoundsException.class,
                () -> {

                    burger.removeIngredient(1);
                });
    }

    @Test
    public void removeIngredientFromBurgerWithExistedIndexCorrectIngredientWasRemoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        burger.removeIngredient(1);
        assertEquals(burger.ingredients.get(0).getName(), "Ing#1", "Ingredient was not removed from burger");
    }

    @Test
    public void moveIngredientBackInBurgerIngredientMoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        Mockito.when(ingredientTwo.getName()).thenReturn("Ing#2");
        Mockito.when(ingredientThree.getName()).thenReturn("Ing#3");
        burger.moveIngredient(1, 0);
        assertEquals(burger.ingredients.get(0).getName(), "Ing#2", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(1).getName(), "Ing#1", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(2).getName(), "Ing#3", "Ingredient was not removed from burger");
    }

    @Test
    public void moveIngredientForwardInBurgerIngredientMoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        Mockito.when(ingredientTwo.getName()).thenReturn("Ing#2");
        Mockito.when(ingredientThree.getName()).thenReturn("Ing#3");
        burger.moveIngredient(0, 1);
        assertEquals(burger.ingredients.get(0).getName(), "Ing#2", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(1).getName(), "Ing#1", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(2).getName(), "Ing#3", "Ingredient was not removed from burger");
    }

    @Test
    public void moveIngredientFirstToLastInBurgerIngredientMoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        Mockito.when(ingredientTwo.getName()).thenReturn("Ing#2");
        Mockito.when(ingredientThree.getName()).thenReturn("Ing#3");
        burger.moveIngredient(0, 2);
        assertEquals(burger.ingredients.get(0).getName(), "Ing#2", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(1).getName(), "Ing#3", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(2).getName(), "Ing#1", "Ingredient was not removed from burger");
    }

    @Test
    public void moveIngredientLastToFirstInBurgerIngredientMoved() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.addIngredient(ingredientThree);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        Mockito.when(ingredientTwo.getName()).thenReturn("Ing#2");
        Mockito.when(ingredientThree.getName()).thenReturn("Ing#3");
        burger.moveIngredient(2, 0);
        assertEquals(burger.ingredients.get(0).getName(), "Ing#3", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(1).getName(), "Ing#1", "Ingredient was not removed from burger");
        assertEquals(burger.ingredients.get(2).getName(), "Ing#2", "Ingredient was not removed from burger");
    }

    @Test
    public void getPriceCorrectValueReturned() {
        Mockito.when(bun.getPrice()).thenReturn(3.03f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(ingredientOne.getPrice()).thenReturn(1.23f);
        burger.addIngredient(ingredientTwo);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(2.34f);
        assertEquals(burger.getPrice(), 3.03f * 2 + 1.23f + 2.34f, "Burger price is calculated incorrectly");
    }

    @Test
    public void gerReceiptCorrectValueReturned() {
        Mockito.when(bun.getPrice()).thenReturn(3.03f);
        Mockito.when(bun.getName()).thenReturn("Bun#1");
        burger.setBuns(bun);
        Mockito.when(ingredientOne.getPrice()).thenReturn(1.23f);
        Mockito.when(ingredientOne.getName()).thenReturn("Ing#1");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredientOne);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(2.34f);
        Mockito.when(ingredientTwo.getName()).thenReturn("Ing#2");
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredientTwo);
        assertEquals(burger.getReceipt(), (String.format("(==== Bun#1 ====)%n= sauce Ing#1 =%n= filling Ing#2 =%n" +
                "(==== Bun#1 ====)%n%nPrice: 9,630000%n")));
    }
}