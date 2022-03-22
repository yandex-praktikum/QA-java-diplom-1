package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBunsCheck() {
        burger.setBuns(burger.bun);
        assertNotNull(burger);
    }

    @Test
    public void addIngredientCheck() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients);
    }

    @Test
    public void removeIngredientCheck() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> expected = new ArrayList<>();
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void moveIngredientCheck() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertNotNull(burger.ingredients.get(1));
    }

    @Test
    public void getPriceCheck() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1.1f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(1.1f);
        float actual = burger.getPrice();
        float expected = 3.3f;
        assertEquals(expected, actual, 0.000002);
    }

    @Test
    public void getReceiptCheck() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1.1f);
        Mockito.when(bun.getName()).thenReturn("Whooper");
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("Beef");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(1.1f);
        String actual = burger.getReceipt();
        String expected = "(==== Whooper ====)\n= filling Beef =\n(==== Whooper ====)\n\nPrice: 3,300000\n";
        assertEquals(expected, actual);
    }
}