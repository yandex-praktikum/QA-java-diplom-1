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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredientInBurger() {
        int ingredientsExpectedCount = 1;
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredientsExpectedCount, burger.ingredients.size());
    }

    @Test
    public void checkRemoveIngredient() {
        List<Ingredient> expected = new ArrayList<>();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients);
    }

    @Test
    public void checkMoveIngredientsInBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Assert.assertNotNull(burger.ingredients.get(1));
    }

    @Test
    public void priceShouldBeGreaterThanZero() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(1000));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(1000));
        Assert.assertTrue(burger.getPrice() > 0.0f);
    }

    @Test
    public void receiptShouldNotBeEmpty() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("BunName");
        Mockito.when(ingredient.getName()).thenReturn("IngredientName");
        Mockito.when((ingredient.getType())).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Assert.assertFalse(burger.getReceipt().isEmpty());
    }
}