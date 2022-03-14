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
        burger.setBuns(bun);
        assertNotNull(bun);
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
        Mockito.when(bun.getPrice()).thenReturn((float) 1.1);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 1.1);
        float actual = burger.getPrice();
        float expected = (float) 3.3;
        System.out.println(actual);
        assertEquals(expected, actual, 0.000002);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn((float) 1.1);
        Mockito.when(bun.getName()).thenReturn("Whooper");
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getName()).thenReturn("Beef");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn((float) 1.1);
        String actual = burger.getReceipt();
        System.out.println(actual);
        String expected = "(==== Whooper ====)\n= filling Beef =\n(==== Whooper ====)\n\nPrice: 3,300000\n";
        assertEquals(expected, actual);
    }
}