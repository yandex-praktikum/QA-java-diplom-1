import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient sauceIngredient;
    @Mock
    Ingredient fillingIngredient;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(fillingIngredient);
        assertTrue(burger.ingredients.contains(fillingIngredient));
    }
    @Test
    public void removeIngredientsTest() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.contains(fillingIngredient));
    }
    @Test
    public  void moveIngredientsTest() {
        burger.addIngredient(sauceIngredient);
        burger.addIngredient(fillingIngredient);
        burger.moveIngredient(0,1);
        Ingredient expected = burger.ingredients.get(0);
        Ingredient actual = fillingIngredient;
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.ingredients.add(sauceIngredient);
        burger.ingredients.add(fillingIngredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(sauceIngredient.getPrice()).thenReturn(200F);
        Mockito.when(fillingIngredient.getPrice()).thenReturn(100F);
        float expected = 500F;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }
    @Test
    public  void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(sauceIngredient);
        burger.ingredients.add(fillingIngredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(sauceIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(fillingIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(sauceIngredient.getName()).thenReturn("sour cream");
        Mockito.when(fillingIngredient.getName()).thenReturn("cutlet");
        Mockito.when(sauceIngredient.getPrice()).thenReturn(200F);
        Mockito.when(fillingIngredient.getPrice()).thenReturn(100F);
        String actual = burger.getReceipt();
        String expected =
                "(==== " + bun.getName() + " ====)\r\n" +
                "= sauce sour cream =\r\n" +
                "= filling cutlet =\r\n" +
                "(==== " + bun.getName() + " ====)\r\n" +
                "\r\n" +
                "Price: 500,000000\r\n";
        assertEquals(expected, actual);
    }
}
