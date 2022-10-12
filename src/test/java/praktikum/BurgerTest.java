package praktikum;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest extends TestCase {

    @Mock
    Ingredient mockIngredient; // создали мок
    @Mock
    Ingredient mockIngredient2; // создали мок
    @Mock
    Bun mockBun; // создали мок

    Burger burger = new Burger();

    @Test
    public void testAddFewIngredients() {
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);
        Assert.assertEquals(List.of("Pelmehka", "Pelmehka2"), getListNamesFromIngredients());
    }

    private List getListNamesFromIngredients() {
        Mockito.when(mockIngredient.getName()).thenReturn("Pelmehka");
        Mockito.when(mockIngredient2.getName()).thenReturn("Pelmehka2");
        List myList = new ArrayList();
        for (Ingredient ingredient : burger.ingredients) {
            myList.add(ingredient.getName());
        }
        return myList;
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(1);
        Assert.assertEquals(List.of("Pelmehka"), getListNamesFromIngredients());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(List.of("Pelmehka2", "Pelmehka"), getListNamesFromIngredients());
    }

    @Test
    public void testSetNameBun() {
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testGetPriceBurger() {
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockIngredient.getPrice()).thenReturn(200F);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        Assert.assertEquals(600F, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("black");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING).toString().toLowerCase();
        Mockito.when(mockIngredient.getName()).thenReturn("ketchup");
        Mockito.when(mockBun.getPrice()).thenReturn(100F);
        Mockito.when(mockIngredient.getPrice()).thenReturn(200F);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        burger.getPrice();
        String expected = "(==== black ====)\r\n" +
                "= filling ketchup =\r\n" +
                "= filling ketchup =\r\n" +
                "(==== black ====)\r\n" +
                "\r\n" +
                "Price: 600,000000\r\n";
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
