import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private IngredientType ingredientType;

    private static final String BUN_NAME = "red bun";
    private static final String INGREDIENT_NAME = "cutlet";
    private static final String INGREDIENT_TYPE = "FILLING";
    private static final float BUN_PRICE = 300f;
    private static final float INGREDIENT_PRICE = 300f;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();

        // Stubs for Bun class
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);

        // Stubs for Ingredient class
        Mockito.when(ingredient.getName()).thenReturn(INGREDIENT_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(INGREDIENT_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);

        // Stubs for IngredientType class
        Mockito.when(ingredientType.toString()).thenReturn(INGREDIENT_TYPE);

    }

    @Test
    public void shouldSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldGetOnlyBunPrice() {
        burger.setBuns(bun);
        assertEquals(2 * BUN_PRICE, burger.getPrice(), 0);
    }

    @Test
    public void shouldGetBurgerPrice() {
        burger.setBuns(bun);
        int iCount = 3;
        for (int i = 0; i < iCount; i++)
            burger.ingredients.add(ingredient);

        assertEquals(2 * BUN_PRICE + iCount * INGREDIENT_PRICE, burger.getPrice(), 0);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldMoveIngredientToEnd() {
        int currentPosition = 0;
        int newPosition = 9;
        for (int i = 0; i <= newPosition; i++) {
            burger.ingredients.add(Mockito.mock(Ingredient.class));
        }
        Ingredient selected = burger.ingredients.get(currentPosition);
        burger.moveIngredient(currentPosition, newPosition);
        assertEquals(selected, burger.ingredients.get(newPosition));
    }

    @Test
    public void shouldRemoveIngredients() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void shouldGetReceipt() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        String receipt = burger.getReceipt();
        String expectedResult = String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("= %s %s =%n", INGREDIENT_TYPE.toLowerCase(), INGREDIENT_NAME) +
                String.format("(==== %s ====)%n", BUN_NAME) +
                String.format("%nPrice: %f%n", 2 * BUN_PRICE + INGREDIENT_PRICE);

        assertEquals(expectedResult, receipt);
    }
}
