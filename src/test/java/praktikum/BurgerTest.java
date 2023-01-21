package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private String bunName = "hello";
    private float price = 100.0F;
    private IngredientType ingredientType = SAUCE;
    private String ingredientName = "bye";
    private Bun bun = new Bun(bunName, price);
    private Ingredient ingredient = new Ingredient(ingredientType, ingredientName, price);


    @Mock
    private Bun mockBun;
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.spy(bun);
        mockIngredient = Mockito.spy(ingredient);
    }

    @Test
    public void setBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(mockIngredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredient() {
        burger.ingredients.add(mockIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(mockIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(ingredient, burger.ingredients.get(1));
        assertEquals(mockIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.bun = mockBun;
        burger.ingredients.add(mockIngredient);
        when(mockBun.getPrice()).thenReturn(price);
        when(mockIngredient.getPrice()).thenReturn(price);
        burger.getPrice();
        verify(mockBun, times(1)).getPrice();
        verify(mockIngredient, times(1)).getPrice();
        assertEquals(300.0F, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceipt() {
        burger.bun = mockBun;
        burger.ingredients.add(mockIngredient);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn(ingredientName);
        when(mockBun.getName()).thenReturn(bunName);
        String receipt = burger.getReceipt();
        verify(mockIngredient, times(1)).getType();
        verify(mockIngredient, times(1)).getName();
        verify(mockBun, times(2)).getName();
        assertFalse(receipt.isEmpty());
    }
}