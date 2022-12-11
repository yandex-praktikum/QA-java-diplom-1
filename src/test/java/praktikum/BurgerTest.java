package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private final float price = 25.0f;
    private final String bunName = "Наименование булки";
    private final String ingredientName = "Наименование ингредиентов";
    private final IngredientType ingredientType = SAUCE;
    private final Ingredient ingredient = new Ingredient(ingredientType, ingredientName, price);
    private final Bun bun = new Bun(bunName, price);

    @Mock
    Bun mockBun;
    Ingredient mockIngredient;
    Burger mockBurger;

    @Before
    public void createBurger() {
        burger = new Burger();
        mockIngredient = Mockito.spy(ingredient);
        mockBun = Mockito.spy(bun);
        mockBurger = Mockito.spy(burger);
    }

    @Test
    public void shouldSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, Burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void shouldDeleteIngredient() {
        burger.ingredients.add(mockIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void shouldMoveIngredient() {
        burger.ingredients.add(mockIngredient);
        burger.ingredients.add(ingredient);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void shouldGetPrice() {
        burger.ingredients.add(mockIngredient);
        burger.ingredients.add(mockIngredient);
        Burger.bun = mockBun;
        Mockito.when(mockBun.getPrice()).thenReturn(price);
        Mockito.when(mockIngredient.getPrice()).thenReturn(price);
        burger.getPrice();
        Mockito.verify(mockBun).getPrice();
        Mockito.verify(mockIngredient, times(2)).getPrice();
        assertEquals(100.0f, burger.getPrice(), 0);
    }

    @Test
    public void shouldGetReceipt() {
        Burger.bun = mockBun;
        burger.ingredients.add(mockIngredient);
        Mockito.when(mockIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(mockIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        String receipt = burger.getReceipt();
        Mockito.verify(mockIngredient, times(1)).getType();
        Mockito.verify(mockIngredient, times(1)).getName();
        Mockito.verify(mockBun, times(2)).getName();
        assertFalse(receipt.isEmpty());
    }
}