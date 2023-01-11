package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient Sauce;
    @Mock
    private Ingredient Filling;

    @Before
    public void createNewBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(Sauce);
        burger.addIngredient(Filling);
        burger.moveIngredient(0, 1);
        assertEquals(Sauce, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(400.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        // 2 булки + соус = 400 * 2 + 200 = 1000
        assertEquals(1000.0f, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100.0f);
        burger.addIngredient(ingredient);
        String expected = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 500,000000" + "\n";
        assertEquals(expected, burger.getReceipt());
    }
}