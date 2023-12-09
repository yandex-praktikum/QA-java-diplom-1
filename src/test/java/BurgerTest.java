import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun mockBun; // Mock object for Bun
    @Mock
    private Ingredient mockIngredient1; // Mock object for Ingredient
    @Mock
    private Ingredient mockIngredient2; // Mock object for Ingredient

    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mock objects
        burger = new Burger();
        burger.setBuns(mockBun); // Set a mock bun to isolate Burger from Bun dependencies

        // Define behavior of mocked ingredients to control their behavior and isolate Burger from Ingredient dependencies
        when(mockIngredient1.getPrice()).thenReturn(50f); // Stubbing getPrice method of mockIngredient1
        when(mockIngredient2.getPrice()).thenReturn(60f); // Stubbing getPrice method of mockIngredient2

        // Define behavior for the mocked bun and ingredients for receipt generation
        when(mockBun.getName()).thenReturn("white bun"); // Stubbing getName method of mockBun
        when(mockIngredient1.getName()).thenReturn("ketchup"); // Stubbing getName method of mockIngredient1
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE); // Stubbing getType method of mockIngredient1
        when(mockIngredient2.getName()).thenReturn("beef patty"); // Stubbing getName method of mockIngredient2
        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING); // Stubbing getType method of mockIngredient2
    }

    @Test
    public void testAddIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient1);

        // Act & Assert
        assertTrue("Burger should contain the added ingredient.", burger.ingredients.contains(mockIngredient1));
    }

    @Test
    public void testRemoveIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        burger.removeIngredient(0);

        // Assert
        assertFalse("Burger should not contain the removed ingredient.", burger.ingredients.contains(mockIngredient1));
        assertTrue("Burger should still contain the other ingredient.", burger.ingredients.contains(mockIngredient2));
    }

    @Test
    public void testMoveIngredient() {
        // Arrange
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Act
        burger.moveIngredient(0, 1);

        // Assert
        assertEquals("The first ingredient should now be in the second position.", mockIngredient2, burger.ingredients.get(0));
        assertEquals("The second ingredient should now be in the first position.", mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetReceipt() {
        // Arrange
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // The expected receipt
        String expectedReceipt = "(==== white bun ====)\n" +
                "= sauce ketchup =\n" +
                "= filling beef patty =\n" +
                "(==== white bun ====)\n\n" +
                "Price: 110.000000\n";

        // Act
        String actualReceipt = burger.getReceipt().trim();


        // Assert
        assertEquals("The receipt should correctly list the bun and ingredients including the price.", expectedReceipt.trim(), actualReceipt);
    }


}
