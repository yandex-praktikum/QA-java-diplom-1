package praktikum;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Ingredient ingredientFirst;

    @Mock
    Ingredient ingredientSecond;

    @Mock
    Bun bun;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(20F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(20F);
        Assert.assertEquals(80F, burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        String expextedReceipt = "(==== булка ====)\r\n" + "= filling мясо =\r\n" + "= sauce нежный =\r\n" + "(==== булка ====)\r\n" + "\r\n" + "Price: 0,000000\r\n";
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getName()).thenReturn("булка");
        Mockito.when(ingredientFirst.getName()).thenReturn("мясо");
        Mockito.when(ingredientSecond.getName()).thenReturn("нежный");
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSecond.getType()).thenReturn(IngredientType.SAUCE);
        Assert.assertEquals(expextedReceipt, burger.getReceipt());
    }

}
