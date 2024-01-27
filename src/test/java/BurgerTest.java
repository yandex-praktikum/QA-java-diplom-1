import org.junit.Assert;
import org.junit.Before;
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
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient hotSauce;
    @Mock
    Ingredient dinosaur;

    @Before
    public void startTest() {
        burger = new Burger();
    }

    @Test
    public void checkSetBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(hotSauce);
        Assert.assertTrue(burger.ingredients.contains(hotSauce));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(hotSauce);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(hotSauce));
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(hotSauce);
        burger.addIngredient(dinosaur);
        burger.moveIngredient(1, 0);
        assertEquals(dinosaur, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(hotSauce);
        burger.addIngredient(dinosaur);

        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(hotSauce.getPrice()).thenReturn(100f);
        Mockito.when(dinosaur.getPrice()).thenReturn(250f);

        assertEquals(450f, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(bun.getName()).thenReturn("black bun");

        Mockito.when(hotSauce.getPrice()).thenReturn(200f);
        Mockito.when(hotSauce.getName()).thenReturn("chili sauce");
        Mockito.when(hotSauce.getType()).thenReturn(SAUCE);
        burger.addIngredient(hotSauce);

        Mockito.when(dinosaur.getPrice()).thenReturn(300f);
        Mockito.when(dinosaur.getName()).thenReturn("cutlet");
        Mockito.when(dinosaur.getType()).thenReturn(FILLING);
        burger.addIngredient(dinosaur);

        String lineSeparator = System.lineSeparator();
        String expected = String.format("(==== black bun ====)" + lineSeparator +
                "= sauce chili sauce =" + lineSeparator +
                "= filling cutlet =" + lineSeparator +
                "(==== black bun ====)" + lineSeparator +
                lineSeparator +
                "Price: 700,00" +
                lineSeparator);
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

}