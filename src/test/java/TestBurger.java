import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Spy
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(2)).setBuns(bun);
    }
    @Test
    public void testAddIngredientInputData() {
        burger.addIngredient(new Database().availableIngredients().get(0));
        int actual = burger.ingredients.size();
        assertEquals(1, actual);
    }
    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(new Database().availableIngredients().get(0));
        burger.ingredients.add(new Database().availableIngredients().get(1));
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals(1, actual);
    }
    @Test
    public void testMoveIngredientIndexVerify() {
        burger.ingredients.add(new Database().availableIngredients().get(0));
        burger.ingredients.add(new Database().availableIngredients().get(1));
        Object expected = burger.ingredients.get(1);
        burger.ingredients.add(new Database().availableIngredients().get(2));
        burger.ingredients.add(new Database().availableIngredients().get(3));
        burger.moveIngredient(1, 3);
        Object actual = burger.ingredients.get(3);
        assertEquals(expected, actual);
    }
    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        float expected = 800f;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(burger.getPrice()).thenReturn(300f);
        String expected = "(==== black bun ====)\r\n= filling cutlet =\r\n(==== black bun ====)\r\n\r\nPrice: 300,000000\r\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}