package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import utils.TestDataProvider;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Database database;

    @Before
    public void setUp() {
        burger  = new Burger();

        Mockito.when(database.availableBuns()).thenReturn(TestDataProvider.getDeFaultBuns());
        List<Bun> buns = database.availableBuns();

        Mockito.when(database.availableIngredients()).thenReturn(TestDataProvider.getDefaultIngredients());
        List<Ingredient> ingredients = database.availableIngredients();

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));
        burger.addIngredient(ingredients.get(3));
    }

    @Test
    public void getPriceShouldReturnExpectedPrice() {
        float expectedPrice = 848.19f;
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptShouldContainAllIngredients() {
        String expectedReceipt = TestDataProvider.getDefaultReceipt();

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void getReceiptShouldNotContainRemovedIngredients() {
        burger.removeIngredient(1);

        String actualReceipt = burger.getReceipt();

        assertFalse(actualReceipt.contains("= filling test ingredient two ="));
    }

    @Test
    public void getReceiptShouldContainAddedIngredients() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "added test ingredient", 110));

        String actualReceipt = burger.getReceipt();

        assertTrue(actualReceipt.contains("= filling added test ingredient ="));
    }

    @Test
    public void moveIngredientShouldChangeIngredientsList() {
        String expectedIndexName = "test sauce one";
        String message = String.format("Ingredient at index 1 should be '%s'", expectedIndexName);

        burger.moveIngredient(2, 1);

        assertEquals(message, expectedIndexName, burger.ingredients.get(1).name);
    }
}
