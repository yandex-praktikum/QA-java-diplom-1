import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import praktikum.*;

public class BurgerTest {
    private static final float DELTA = 0.001f;
    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.setBuns(mockBun);
    }
    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(mockIngredient1));
    }
    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(mockIngredient1));
        assertTrue(burger.ingredients.contains(mockIngredient2));
    }
    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }
    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient1.getPrice()).thenReturn(1.0f);
        when(mockIngredient2.getPrice()).thenReturn(1.5f);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expectedPrice = 2.0f*2 + 1.0f + 1.5f;
        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }
    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("Bun");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn("Ingredient1");
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn("Ingredient2");
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String expectedReceipt = "(==== Bun ====)\n" +
                "= sauce Ingredient1 =\n" +
                "= filling Ingredient2 =\n" +
                "(==== Bun ====)\n" +
                "\n" +
                "Price: 0,000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}