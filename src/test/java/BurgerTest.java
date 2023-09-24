import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Before
    public void setUp() {
        burger = new Burger();
    }
    @Test
    public void setBurgerBun() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void addBurgerIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(List.of(ingredient), burger.ingredients);
    }
    @Test
    public void removeBurgerIngredient() {
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveBurgerIngredient() {
        Ingredient ingredientCucumber = new Ingredient(IngredientType.FILLING, "Огурчик",2.5F);
        Ingredient ingredientCheese = new Ingredient(IngredientType.FILLING,"Сыр",8.2F );
        burger.addIngredient(ingredientCucumber);
        burger.addIngredient(ingredientCheese);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredientCucumber, burger.ingredients.get(1));
    }
    @Test
    public void getBurgerPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(5F);
        Mockito.when(ingredient.getPrice()).thenReturn(2.5F);
        float totalBurgerPrice = 5F * 2F + 2.5F;
        Assert.assertEquals(totalBurgerPrice, burger.getPrice(), 0);
    }
    @Test
    public void getBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("По вкусу вкусная");
        Mockito.when(bun.getPrice()).thenReturn(7.5F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Огурчик");
        Mockito.when(ingredient.getPrice()).thenReturn(2.5F);
        String totalBurgerReceipt = "(==== По вкусу вкусная ====)" + "\r\n" + "= filling Огурчик =" + "\r\n" + "(==== По вкусу вкусная ====)" + "\r\n" + "\r\n" + "Price: 17,500000" + "\r\n";
        Assert.assertEquals(totalBurgerReceipt, burger.getReceipt());
    }
}