package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Test
    public void testBurgerGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(75f);

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(325f, burger.getPrice(), 0.01);
    }

    @Test
    public void testBurgerGetReceipt() {
        when(mockBun.getName()).thenReturn("Test Bun");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("Test Ingredient");

        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        String expectedReceipt = "(==== Test Bun ====)\n= filling Test Ingredient =\n(==== Test Bun ====)\n\nPrice: 0.000000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertSame(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(2, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(mockIngredient1));
        assertTrue(burger.ingredients.contains(mockIngredient2));
    }

    @Test
    public void testRemoveIngredient() {
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(mockIngredient1));
        assertTrue(burger.ingredients.contains(mockIngredient2));
    }

    @Test
    public void testMoveIngredient() {
        burger.ingredients.add(mockIngredient1);
        burger.ingredients.add(mockIngredient2);

        burger.moveIngredient(1, 0);

        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }
}
