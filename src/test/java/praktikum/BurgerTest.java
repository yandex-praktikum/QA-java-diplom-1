package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Bun bun;


    @Test
    public void addIngredientTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(1));
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));
        burger.moveIngredient(1, 0);
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void getCorrectPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(12.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(3.00f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(27.00f, burger.getPrice(), 0.0);
    }

    @Test
    public void getCorrectReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getName()).thenReturn("sauce chili");
        Mockito.when(ingredient1.getName()).thenReturn("felling cutlet");

        Mockito.when(bun.getPrice()).thenReturn(12.00f);
        Mockito.when(ingredient.getPrice()).thenReturn(3.00f);
        Mockito.when(ingredient1.getPrice()).thenReturn(5.00f);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.getReceipt();
        final String expected = "(==== black bun ====)\r\n" +
                "= sauce sauce chili =\r\n" +
                "= filling felling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 32,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}