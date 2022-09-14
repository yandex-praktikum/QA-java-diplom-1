package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void checkAddIngredientForBurger(){

        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Tomato", 100.0f);
        burger.addIngredient(ingredient);
        int actualSizeOfIngredientsList = burger.ingredients.size();

        int expectedSizeOfIngredientsList = 1;
        Assert.assertEquals("An ingredient was not added", expectedSizeOfIngredientsList, actualSizeOfIngredientsList);

    }

    @Test
    public void checkRemoveIngredient(){

        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Tomato", 100.0f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualSizeOfIngredientsList = burger.ingredients.size();

        int expectedSizeOfIngredientsList = 0;
        Assert.assertEquals("An ingredient was not removed", expectedSizeOfIngredientsList, actualSizeOfIngredientsList);

    }

    @Test
    public void checkMoveIngredients(){

        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Tomato", 100.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Onion", 50.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Ingredient actualSecondIngredient = burger.ingredients.get(0);

        String expectedSecondIngredient = "Onion";
        Assert.assertEquals("An ingredient was not removed", expectedSecondIngredient, actualSecondIngredient.getName());
    }

    @Test
    public void checkGetPriceReturnsPriceForBun(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200.0f);

        float expectedPrice=400.0f;
        Assert.assertEquals("Price is not equal expectedPrice for bun", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetPriceReturnsPriceForBunAndIngredient(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(400.0f);

        float expectedPrice=1000.0f;
        Assert.assertEquals("Price is not equal expectedPrice for bun and ingredient", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceiptForBurger(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Onion");
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(400.0f);
        String actualReceipt = burger.getReceipt();

        String expectedReceipt = "(==== white ====)\r\n" +
                "= filling Onion =\r\n" +
                "(==== white ====)\r\n" +
                "\r\n" +
                "Price: 1000,000000" +
                "\r\n";

        Assert.assertEquals("Receipt for burger is incorrect", expectedReceipt, actualReceipt);
    }
}
