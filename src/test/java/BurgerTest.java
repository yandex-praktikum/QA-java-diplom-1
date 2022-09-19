import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    Database database = new Database();
    List<Ingredient> ingredients = database.availableIngredients();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;


    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        float expectedPrice = 300;
        float actualPrice = burger.getPrice();
        assertEquals("Price incorrect", expectedPrice, actualPrice, 0);
    }

    @Test
    public void addIngredientTest() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int actualResult = burger.ingredients.size();
        int expectedResult = 2;
        assertEquals("Method incorrect", expectedResult, actualResult);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        String actual = burger.ingredients.get(0).getName();
        String expected = "sour cream";
        assertEquals("Ingredient is incorrect", expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== red bun ====)\r\n" +
                "= filling cutlet =\r\n" +
                "(==== red bun ====)\r\n" +
                "\r\n" +
                "Price: 900,000000\r\n";
        assertEquals("Receipt incorrect", expectedReceipt, actualReceipt);
    }

}

