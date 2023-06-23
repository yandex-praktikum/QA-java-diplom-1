package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Тесты для класса /src/main/java/Burger.
 */
public class BurgerTest {
    private AutoCloseable closeable;
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient oneMoreIngredient;

    @Spy
    private Burger burger;

    @Before
    public void setupTest() {
        closeable = MockitoAnnotations.openMocks(this);
        when(bun.getName()).thenReturn("Мягкая французская булочка");
        when(bun.getPrice()).thenReturn(0.25f);
        when(ingredient.getPrice()).thenReturn(0.15f);
        when(ingredient.getName()).thenReturn("chili sauce");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(oneMoreIngredient.getPrice()).thenReturn(0.15f);
        when(oneMoreIngredient.getName()).thenReturn("cutlet");
        when(oneMoreIngredient.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void setBunsCallSetBunsIsCalled() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientIngredientAdded() {
        burger.addIngredient(ingredient);
        assertNotNull(burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientIngredientRemoved() {
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientIngredientMoved() {
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        burger.moveIngredient(1, 0);
        burger.ingredients.get(1).getName();
        Mockito.verify(ingredient).getName();
    }

    @Test
    public void getPriceReturnedPriceOfTheBurger() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        assertEquals(0.8, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptCorrectReceiptReceived() {
        burger.setBuns(bun);
        burger.ingredients.addAll(List.of(ingredient, oneMoreIngredient));
        String expected = "(==== Мягкая французская булочка ====)\n" +
                "= sauce chili sauce =\n" +
                "= filling cutlet =\n" +
                "(==== Мягкая французская булочка ====)\n" +
                "\nPrice: 0,800000\n";
        assertEquals(expected, burger.getReceipt());
    }

    @After
    public void teardownTest() throws Exception {
        closeable.close();
    }
}