import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Test
    public void checkSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
    }
    @Test
    public void checkAddIngredientTest(){
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(1));
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }

    @Test
    public void checkRemoveIngredientAfterAddingTest(){
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void checkMoveIngredientAfterAddingTest(){
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        assertEquals(ingredients.get(1), burger.ingredients.get(0));
    }
    @Test
    public void checkPriceBurgerTest(){
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.getPrice();
        assertEquals(300, burger.getPrice(), 0);
    }
    @Test
    public void checkReceiptBurgerTest(){
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(ingredient.getName()).thenReturn("chicken cutlet");
        Mockito.when(bun.getPrice()).thenReturn(7F);
        Mockito.when(ingredient.getPrice()).thenReturn(15F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.getReceipt();
        final String expected = "(==== red bun ====)\r\n" +
                "= filling chicken cutlet =\r\n" +
                "(==== red bun ====)\r\n" +
                "\r\n" +
                "Price: 29,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}

