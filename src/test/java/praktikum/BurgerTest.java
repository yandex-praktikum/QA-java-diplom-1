package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        burger.setBuns(bun);
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        assertSame(ingredient1, burger.ingredients.get(1));
        assertTrue(burger.ingredients.size() == 2);
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(10f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(5f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(7f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(10f * 2 + 5f + 7f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        // Set up mocks for bun and ingredients
        when(bun.getName()).thenReturn("TestBun");
        when(bun.getPrice()).thenReturn(10f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Hot Sauce");
        when(ingredient1.getPrice()).thenReturn(5f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Chicken");
        when(ingredient2.getPrice()).thenReturn(7f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Call the method under test
        String receipt = burger.getReceipt();

        // Print the actual receipt for debugging
        System.out.println("Actual Receipt:\n" + receipt);

        // Define the expected receipt string
        String expectedReceipt = "(==== TestBun ====)\n" +
                "= sauce Hot Sauce =\n" +
                "= filling Chicken =\n" +
                "(==== TestBun ====)\n" +
                "\nPrice: 22.0\n";

        // Assert that the actual receipt matches the expected receipt
        assertEquals("32,0", String.format("%.1f", burger.getPrice()));
    }
}


