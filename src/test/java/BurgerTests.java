import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTests {

@Mock
Bun bun = new Bun("black bun", 100);
@Mock
Ingredient ingredient = new Ingredient(IngredientType.FILLING, "chicken", 200);
@Mock
Ingredient ingredientTwo = new Ingredient(IngredientType.SAUCE, "tabasco", 120);

Burger burger = new Burger();
List<Ingredient> ingredients = burger.ingredients;

    @Test
    public void ingredientAddSuccessfullyTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, ingredients.size());

    }
    @Test
    public void ingredientMoveSuccessfullyTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        Assert.assertEquals(2, ingredients.size());
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientTwo, ingredients.get(0));
    }
    @Test
    public void ingredientRemoveSuccessfullyTest() {
        burger.addIngredient(ingredientTwo);
        Assert.assertEquals(1, ingredients.size());
        burger.removeIngredient(0);
        Assert.assertTrue(ingredients.isEmpty());
    }
    @Test
    public void getBurgerPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(85F);
        Mockito.when(ingredient.getPrice()).thenReturn(150F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(2, ingredients.size());
        float actual = burger.getPrice();
        Assert.assertEquals(470F, actual, 0F);
    }
    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn("chicken");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getPrice()).thenReturn(85F);
        Mockito.when(bun.getName()).thenReturn("булонька");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        String expected = "(==== булонька ====)\r\n" + "= filling chicken =\r\n" + "= filling chicken =\r\n" + "(==== булонька ====)\r\n" + "\r\n" +
                "Price: 170,000000\r\n";;
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
