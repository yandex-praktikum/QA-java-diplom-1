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
    Bun mockBun; // создали мок

    Burger burger = new Burger();

    @Test
    public void testAddFewIngredients() {
        addIngredientToBurger(IngredientType.SAUCE, "ketchup", 100);
        addIngredientToBurger(IngredientType.FILLING, "cucumber", 200);
        Assert.assertEquals(List.of("ketchup", "cucumber"), getListNamesFromIngredients());
    }

    private void addIngredientToBurger(IngredientType type, String name, int price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        burger.addIngredient(ingredient);
    }

    private List getListNamesFromIngredients() {
        List myList = new ArrayList();
        for (Ingredient burgerIngredient : burger.ingredients) {
            myList.add(burgerIngredient.getName());
        }
        return myList;
    }

    @Test
    public void testRemoveIngredient() {
        addIngredientToBurger(IngredientType.SAUCE, "ketchup", 100);
        addIngredientToBurger(IngredientType.FILLING, "cucumber", 200);
        burger.removeIngredient(1);
        Assert.assertEquals(List.of("ketchup"), getListNamesFromIngredients());
    }

    @Test
    public void testMoveIngredient() {
        addIngredientToBurger(IngredientType.SAUCE, "ketchup", 100);
        addIngredientToBurger(IngredientType.FILLING, "cucumber", 200);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(List.of("cucumber", "ketchup"), getListNamesFromIngredients());
    }

    @Test
    public void testSetNameBun() {
        Bun bun = new Bun("white", 100);
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
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
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", mockBun.getName()));
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
