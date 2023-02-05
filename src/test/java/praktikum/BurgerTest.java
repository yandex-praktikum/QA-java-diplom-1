package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientCutlet;

    @Mock
    Ingredient ingredientHotSauce;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientCutlet);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientCutlet);
        burger.addIngredient(ingredientHotSauce);
        burger.moveIngredient(0, 1);

        List<Ingredient> expectedIngredients = Arrays.asList(ingredientHotSauce, ingredientCutlet);
        assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();

        Mockito.when(bun.getPrice()).thenReturn(2.5f);
        Mockito.when(ingredientCutlet.getPrice()).thenReturn(0.5f);
        Mockito.when(ingredientHotSauce.getPrice()).thenReturn(0.6f);

        burger.setBuns(bun);
        burger.addIngredient(ingredientCutlet);
        burger.addIngredient(ingredientHotSauce);

        assertEquals(6.1f, burger.getPrice(), 0.0f);
    }
    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredientCutlet.getName()).thenReturn("cutlet");
        Mockito.when(ingredientCutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientHotSauce.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientHotSauce.getType()).thenReturn(IngredientType.SAUCE);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientCutlet);
        burger.addIngredient(ingredientHotSauce);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= filling cutlet =\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n" +
                "\nPrice: 0.000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Mockito.when(ingredientHotSauce.getPrice()).thenReturn(0.6f);
        burger.setBuns(bun);
        burger.addIngredient(ingredientCutlet);
        burger.addIngredient(ingredientHotSauce);
        burger.removeIngredient(0);
        assertEquals(0.6f, burger.getPrice(), 0.0f);
    }


}
