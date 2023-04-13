import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockSauce;
    private Ingredient mockFilling;

    @Before
    public void start() {
        mockBun = new Bun("step", 1f);
        mockSauce = new Ingredient(IngredientType.SAUCE, "ketchup", 2f);
        mockFilling = new Ingredient(IngredientType.FILLING, "beef patty", 3f);
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