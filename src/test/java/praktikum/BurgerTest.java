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
    private Ingredient firstIngredient;
    @Mock
    private Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger= new Burger();
        burger.setBuns(bun);
    }
    @Test
    public void testAddIngredient() {
        burger.addIngredient(firstIngredient);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(Arrays.asList(secondIngredient, firstIngredient), burger.ingredients);
    }
    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(firstIngredient.getPrice()).thenReturn(50f);
        when(secondIngredient.getPrice()).thenReturn(75f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        assertEquals(325f, burger.getPrice(), 0);
    }
    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Black bun");
        when(firstIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(firstIngredient.getName()).thenReturn("Cutlet");
        when(firstIngredient.getPrice()).thenReturn(100F);
        when(secondIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(secondIngredient.getName()).thenReturn("Hot sauce");
        when(secondIngredient.getPrice()).thenReturn(50F);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expected = "(==== Black bun ====)\n" +
                "= filling Cutlet =\n" +
                "= sauce Hot sauce =\n" +
                "(==== Black bun ====)\n" +
                "\n" +
                "Price: 150,000000\n";
        assertEquals(expected, burger.getReceipt());
    }
}
