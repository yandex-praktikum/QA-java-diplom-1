package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        String name = "mock ingredient";
        Ingredient mock = mock(Ingredient.class, withSettings().name(name));
        burger.addIngredient(ingredient);
        burger.addIngredient(mock);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(name, burger.ingredients.get(0).toString());
    }

    @Test
    public void testGetPrice() {
        float price = 25.0f;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        String bunName = "bulochka";
        String ingredientName = "fillet";
        IngredientType ingredientType = FILLING;
        String expectedResult = String.format("(==== %s ====)" + "\n"
        + "= %s %s =" + "\n" + "(==== %s ====)" + "\n" + "\n" + "Price: %f%n",
                bunName, ingredientType.toString().toLowerCase(), ingredientName, bunName, ingredient.getPrice());
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(bunName);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn(ingredientName);
        when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertEquals(expectedResult, burger.getReceipt());
    }
}