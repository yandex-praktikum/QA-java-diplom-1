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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientNew;

    @Mock
    Bun bun;

    @Test
    public void checkBun() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.getBuns());
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.getIngredients().contains(ingredient));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.getIngredients().contains(ingredient));
        burger.removeIngredient(burger.getIngredients().size() - 1);
        assertFalse(burger.getIngredients().contains(ingredient));
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientNew);

        int ingredientIndex = burger.getIngredients().size() - 2;
        int ingredientNewIndex = burger.getIngredients().size() - 1;
        burger.moveIngredient(ingredientIndex, ingredientNewIndex);

        assertEquals(ingredient, burger.getIngredients().get(ingredientNewIndex));
        assertEquals(ingredientNew, burger.getIngredients().get(ingredientIndex));
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = 99f;

        Mockito.when(bun.getPrice()).thenReturn(30f);
        Mockito.when(ingredient.getPrice()).thenReturn(39f);

        burger.addIngredient(ingredient);
        burger.setBuns(bun);

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("ingredient_name");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("filling_name");
        Mockito.when(bun.getPrice()).thenReturn(30f);
        Mockito.when(ingredient.getPrice()).thenReturn(39f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expectedReceipt =
                "(==== ingredient_name ====)\r\n" +
                "= filling filling_name =\r\n" +
                "(==== ingredient_name ====)\r\n" +
                "\r\n" +
                "Price: 99,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
