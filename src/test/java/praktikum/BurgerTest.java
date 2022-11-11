package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void addIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertFalse("Ингредиент не был добавлен!", burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertFalse("Ингредиент не был добавлен!", burger.ingredients.isEmpty());
        burger.removeIngredient(0);
        Assert.assertTrue("Ингредиент не был удален!", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertTrue("Ингредиент не был перемещен", burger.ingredients.get(1) == ingredient1 && burger.ingredients.get(0) == ingredient2);
    }

    @Test
    public void getPriceTest() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(30.5f);
        Mockito.when(ingredient1.getPrice()).thenReturn(30.5f);
        Mockito.when(ingredient2.getPrice()).thenReturn(10.5f);
        Assert.assertTrue("Цена за бургер неправильная!", 102f == burger.getPrice());
    }

    @Test
    public void getReceipt() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(ingredient2.getName()).thenReturn("sour cream");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(30.5f);
        Mockito.when(ingredient1.getPrice()).thenReturn(30.5f);
        Mockito.when(ingredient2.getPrice()).thenReturn(30.5f);
        Assert.assertEquals("(==== black bun ====)\n" +
                "= filling cutlet =\n" +
                "= sauce sour cream =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 122.000000"
                + "\n", burger.getReceipt());
    }
}
