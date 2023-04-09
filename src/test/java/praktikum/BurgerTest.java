package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger= new Burger();
        burger.setBuns(bun);
    }
    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(Arrays.asList(ingredient2, ingredient1), burger.ingredients);
    }
    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(75f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(325f, burger.getPrice(), 0);
    }
    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Black bun");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("Cutlet");
        when(ingredient1.getPrice()).thenReturn(100f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Hot sauce");
        when(ingredient2.getPrice()).thenReturn(50f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expected = "(==== Black bun ====)\n" +
                "= filling Cutlet =\n" +
                "= sauce Hot sauce =\n" +
                "(==== Black bun ====)\n" +
                "\n" +
                "Price: 250.0\n";

        assertEquals(expected, burger.getReceipt());
    }
}