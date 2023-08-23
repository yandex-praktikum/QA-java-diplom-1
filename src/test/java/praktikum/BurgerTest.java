package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final String BUN_NAME = "Test Bun";
    private static final float BUN_PRICE = 100f;
    private static final String INGREDIENT_NAME = "Test Ingredient";
    private static final float INGREDIENT_PRICE = 250f;
    private static final float INGREDIENT2_PRICE = 150f;

    Burger burger = new Burger();
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Test
    public void testBurgerGetPrice() {
        when(mockBun.getPrice()).thenReturn(BUN_PRICE);
        when(mockIngredient1.getPrice()).thenReturn(INGREDIENT_PRICE);
        when(mockIngredient2.getPrice()).thenReturn(INGREDIENT2_PRICE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = (BUN_PRICE*2) + INGREDIENT_PRICE + INGREDIENT2_PRICE;
        assertEquals(expectedPrice, burger.getPrice(), 0.01);
    }

    @Test
    public void testBurgerGetReceipt() {
        when(mockBun.getName()).thenReturn(BUN_NAME);
        when(mockBun.getPrice()).thenReturn(BUN_PRICE);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn(INGREDIENT_NAME);
        when(mockIngredient1.getPrice()).thenReturn(INGREDIENT_PRICE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        float expectedPrice = (mockBun.getPrice() * 2) + mockIngredient1.getPrice();
        String[] expectedReceiptLines = {
                "(==== " + mockBun.getName() + " ====)",
                "= " + mockIngredient1.getType().toString().toLowerCase() + " "+ mockIngredient1.getName() +" =",
                "(==== " + mockBun.getName() + " ====)",
                "",
                "Price: "+ String.format("%.6f", expectedPrice),
                ""
        };

        String expectedReceipt = String.join("\n", expectedReceiptLines);

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
