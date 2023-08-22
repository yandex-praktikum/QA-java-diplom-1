import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;

public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Ingredient1", 1.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Ingredient2", 2.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient.getPrice()).thenReturn(1.0f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        assertEquals(6.0f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("Bun");
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getName()).thenReturn("Ingredient");
        when(mockBun.getPrice()).thenReturn(2.0f);
        when(mockIngredient.getPrice()).thenReturn(1.0f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        String expectedReceipt = "(==== Bun ====)%n" +
                "= filling Ingredient =%n" +
                "= filling Ingredient =%n" +
                "(==== Bun ====)%n" +
                "%nPrice: 6.000000%n";
        expectedReceipt = String.format(expectedReceipt);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}