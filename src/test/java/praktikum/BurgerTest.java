package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Spy
    Burger burger = new Burger();

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(firstIngredient);

        int expectedAmountOfIngredients = 1;
        int actualAmountOfIngredients = burger.ingredients.size();

        assertEquals(expectedAmountOfIngredients, actualAmountOfIngredients);
    }

    @Test
    public void testRemoveIngredient() {
        int ingredientIndex = 0;
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(ingredientIndex);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        int newIngredientIndex = 0;
        int oldIngredientIndex = 1;

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(oldIngredientIndex, newIngredientIndex);

        assertEquals(secondIngredient, burger.ingredients.get(newIngredientIndex));
    }

    @Test
    public void testGetPrice() {
        // Stubs
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(300f);

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        float delta = 0.0f;
        float expectedPrice = 700f;
        float actualIngredient = burger.getPrice();

        assertEquals(expectedPrice, actualIngredient, delta);
    }

    @Test
    public void testGetReceipt() {
        // Bun
        Mockito.when(bun.getName()).thenReturn("black bun");
        // Ingredients
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(firstIngredient.getName()).thenReturn("hot sauce");
        Mockito.when(secondIngredient.getName()).thenReturn("cutlet");

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        // Burger
        Mockito.when(burger.getPrice()).thenReturn(400f);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling cutlet =\n" +
                "(==== black bun ====)\n" +
                "\nPrice: 400.000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}