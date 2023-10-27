import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import praktikum.Ingredient;
import praktikum.Bun;
import praktikum.Burger;

import static java.lang.String.format;
import static org.junit.Assert.*;
import static org.mockito.junit.MockitoJUnit.rule;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {

    @Rule
    public MockitoRule mockitoRule = rule();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(burger.bun, bun);
    }

    @Test
    public void CheckAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        boolean isExist = burger.ingredients.stream().anyMatch(i -> i == ingredient);
        assertTrue(isExist);
    }

    @Test
    public void CheckRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int realIndex = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(realIndex);
        boolean isNowExist = burger.ingredients.stream().anyMatch(i -> i == ingredient);
        assertFalse(isNowExist);
    }

    @Test
    public void CheckMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int index1 = burger.ingredients.indexOf(ingredient1);
        int index2 = burger.ingredients.indexOf(ingredient2);
        burger.moveIngredient(index1, index2);
        int newIndex1 = burger.ingredients.indexOf(ingredient1);
        int newIndex2 = burger.ingredients.indexOf(ingredient2);
        assertEquals(index1, newIndex2);
        assertEquals(index2, newIndex1);
    }

    @Test
    public void CheckGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        float actual = burger.getPrice();
        float expected = 250.0F;
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void CheckGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(bun.getPrice()).thenReturn(300.0F);
        StringBuilder receipt = new StringBuilder(format("(==== %s ====)%n", bun.getName()));
        receipt.append(format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        receipt.append(format("(==== %s ====)%n", bun.getName()));
        receipt.append(format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}