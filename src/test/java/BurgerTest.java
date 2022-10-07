import org.codehaus.plexus.util.StringUtils;
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
import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private float price = 1.0f;
    private String bunName = "Amazing bun";
    private String ingrName = "Awesome ingredient";
    private IngredientType ingrType = FILLING;
    private Ingredient ingredient = new Ingredient(ingrType, ingrName, price);
    private Bun bun = new Bun(bunName, price);

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
        assertEquals(mockBun, burger.bun);
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
        burger.bun = mockBun;
        Mockito.when(mockBun.getPrice()).thenReturn(price);
        Mockito.when(mockIngredient.getPrice()).thenReturn(price);
        burger.getPrice();
        Mockito.verify(mockBun).getPrice();
        Mockito.verify(mockIngredient, Mockito.times(2)).getPrice();
        assertEquals(4.0f, burger.getPrice(), 0.0);
    }

    @Test
    public void shouldGetReceipt() {
        mockBurger.ingredients.add(mockIngredient);
        mockBurger.ingredients.add(mockIngredient);
        mockBurger.bun = mockBun;
        Mockito.when(mockIngredient.getType()).thenReturn(ingrType);
        Mockito.when(mockIngredient.getName()).thenReturn(ingrName);
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBurger.getPrice()).thenReturn(4.0f);
        String receipt = mockBurger.getReceipt();
        Mockito.verify(mockIngredient, Mockito.times(2)).getType();
        Mockito.verify(mockIngredient, Mockito.times(2)).getName();
        Mockito.verify(mockBun, Mockito.times(2)).getName();
        Mockito.verify(mockBurger).getPrice();
        assertFalse(receipt.isEmpty());
    }


}
