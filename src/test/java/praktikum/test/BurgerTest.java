package praktikum.test;

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

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockHotSauce;
    @Mock
    Ingredient mockCutlet;
    @Mock
    Ingredient mockDinosaur;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void checkSetBun() {
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(mockHotSauce);
        Assert.assertTrue(burger.ingredients.contains(mockHotSauce));
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(mockHotSauce);
        burger.addIngredient(mockDinosaur);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(mockHotSauce));
    }

    @Test
    public void checkMoveIngredient() {
        burger.addIngredient(mockHotSauce);
        burger.addIngredient(mockCutlet);
        burger.addIngredient(mockDinosaur);
        burger.moveIngredient(2, 0);
        Assert.assertEquals(mockDinosaur, burger.ingredients.get(0));
    }

    @Test
    public void checkGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockHotSauce);
        burger.addIngredient(mockCutlet);
        burger.addIngredient(mockDinosaur);

        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockHotSauce.getPrice()).thenReturn(100F);
        Mockito.when(mockCutlet.getPrice()).thenReturn(100F);
        Mockito.when(mockDinosaur.getPrice()).thenReturn(200F);

        Assert.assertEquals(600F, burger.getPrice(), 0.01);
    }

    @Test
    public void checkGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockHotSauce);
        burger.addIngredient(mockCutlet);
        burger.addIngredient(mockDinosaur);

        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockBun.getName()).thenReturn("black bun");

        Mockito.when(mockHotSauce.getPrice()).thenReturn(100F);
        Mockito.when(mockHotSauce.getName()).thenReturn("hot sauce");
        Mockito.when(mockHotSauce.getType()).thenReturn(SAUCE);

        Mockito.when(mockCutlet.getPrice()).thenReturn(100F);
        Mockito.when(mockCutlet.getName()).thenReturn("cutlet");
        Mockito.when(mockCutlet.getType()).thenReturn(FILLING);

        Mockito.when(mockDinosaur.getPrice()).thenReturn(200F);
        Mockito.when(mockDinosaur.getName()).thenReturn("dinosaur");
        Mockito.when(mockDinosaur.getType()).thenReturn(FILLING);


        String expected = "(==== black bun ====)" + System.lineSeparator() +
                "= sauce hot sauce =" + System.lineSeparator() +
                "= filling cutlet =" + System.lineSeparator() +
                "= filling dinosaur =" + System.lineSeparator() +
                "(==== black bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 600,000000" + System.lineSeparator();

        Assert.assertEquals(expected, burger.getReceipt());
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
}