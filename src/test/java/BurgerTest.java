import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockSauce;
    @Mock
    private Ingredient mockFilling;

    @Before
    public void start() {
        MockitoAnnotations.initMocks(this);
        when(mockBun.getName()).thenReturn("step");
        when(mockBun.getPrice()).thenReturn(1f);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("ketchup");
        when(mockSauce.getPrice()).thenReturn(2f);
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("beef patty");
        when(mockFilling.getPrice()).thenReturn(3f);
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testGetPrice() {
        assertEquals(7f, burger.getPrice(), 0.01);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                "= sauce ketchup =%n" +
                "= filling beef patty =%n" +
                "(==== step ====)%n" +
                "%nPrice: 7,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        burger.removeIngredient(0);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                "(==== step ====)%n" +
                "%n" +
                "Price: 2,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                "= filling beef patty =%n" +
                "= sauce ketchup =%n" +
                "(==== step ====)%n" +
                "%n" +
                "Price: 7,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        String expectedReceipt = String.format(
                "(==== step ====)%n" +
                "= sauce ketchup =%n" +
                "= filling beef patty =%n" +
                "= sauce ketchup =%n" +
                "= filling beef patty =%n" +
                "(==== step ====)%n" +
                "%n" +
                "Price: 12,000000%n");

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}