package praktikum;

import org.junit.Assert;
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
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
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
        burger.addIngredient(ingredient1);
        Assert.assertEquals(1, burger.ingredients.size());
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }
    @Test
    public void getPrice() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient1.getPrice()).thenReturn(20F);
        Mockito.when(ingredient2.getPrice()).thenReturn(30F);
        Assert.assertEquals(70F, burger.getPrice(),0);
    }
    @Test
    public void getReceipt() {
        String expextedReceipt = "(==== булочка ====)\r\n" + "= filling колбаска =\r\n" + "= sauce майонезик =\r\n" +
                "(==== булочка ====)\r\n" + "\r\n" + "Price: 0,000000\r\n";
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("булочка");
        Mockito.when(ingredient1.getName()).thenReturn("колбаска");
        Mockito.when(ingredient2.getName()).thenReturn("майонезик");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Assert.assertEquals(expextedReceipt, burger.getReceipt());
    }
}