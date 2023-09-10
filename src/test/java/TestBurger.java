import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    Bun bun;

    @Mock
    Ingredient chiliSauce;

    @Mock
    Ingredient cutlet;

    @Test
    public void checkSetBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void checkEmptyBun() {
        Burger burger = new Burger();
        Assert.assertNull(burger.bun);
    }

    @Test
    public void checkIngredientsIsEmpty() {
        Burger burger = new Burger();
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void checkAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        Assert.assertTrue(burger.ingredients.contains(chiliSauce));
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(chiliSauce));
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(chiliSauce);
        burger.addIngredient(cutlet);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(cutlet, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(chiliSauce);
        burger.addIngredient(cutlet);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(chiliSauce.getPrice()).thenReturn(200F);
        Mockito.when(cutlet.getPrice()).thenReturn(300F);

        Assert.assertEquals(700F, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(chiliSauce);
        burger.addIngredient(cutlet);

        Mockito.when(bun.getPrice()).thenReturn(1000F);
        Mockito.when(bun.getName()).thenReturn("black bun");

        Mockito.when(chiliSauce.getPrice()).thenReturn(2000F);
        Mockito.when(chiliSauce.getName()).thenReturn("chili sauce");
        Mockito.when(chiliSauce.getType()).thenReturn(SAUCE);

        Mockito.when(cutlet.getPrice()).thenReturn(3000F);
        Mockito.when(cutlet.getName()).thenReturn("cutlet");
        Mockito.when(cutlet.getType()).thenReturn(FILLING);

        String expected = "(==== black bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 7000,000000\r\n";

        Assert.assertEquals(expected, burger.getReceipt());
    }
}