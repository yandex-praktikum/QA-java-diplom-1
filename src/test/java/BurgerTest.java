import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientOne;

    @Test
    public void setBunsBunObjectAssignsValueToTheBunVariable() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientIngredientObjectIngredientAddsToList() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientIndexOfIngredientRemovesIngredientFromListOfIngredients() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientIndexesOfIngredientsMovesIngredients() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientOne);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals(ingredientOne, burger.ingredients.get(0));
    }

    @Test
    public void getPriceReturnsPriceOfBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        assertEquals(300.0, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnsReceiptOfBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("ketchup");
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", bun.getName(), ingredient.getType().toString().toLowerCase(),
                ingredient.getName(), bun.getName(), burger.getPrice());
        assertEquals(expected, burger.getReceipt());
    }

}
