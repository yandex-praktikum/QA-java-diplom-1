import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunActs(){

        Burger  burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void addIngridientActs(){
        Burger  burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void removeIngridientActs(){
        Burger  burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void moveIngridientActs(){
        Burger  burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(2,1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(1));
        Assert.assertEquals(ingredient1, burger.ingredients.get(2));
    }
    @Test
    public void getPriceReturnsCorrectValue(){
        Burger  burger = new Burger();

        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        Mockito.when(ingredient1.getPrice()).thenReturn(30.0f);
        Mockito.when(ingredient2.getPrice()).thenReturn(100.0f);
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice  = 170;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice,0.001);

    }

    @Test
    public void getReceiptReturnsCorrectValue(){
        Burger  burger = new Burger();
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        Mockito.when(ingredient1.getPrice()).thenReturn(30.0f);
        Mockito.when(ingredient2.getPrice()).thenReturn(100.0f);
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Mockito.when(ingredient.getName()).thenReturn("Плюх");
        Mockito.when(ingredient1.getName()).thenReturn("Грох");
        Mockito.when(ingredient2.getName()).thenReturn("Мадрагора");
        Mockito.when(bun.getName()).thenReturn("Блинчик");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt  = "(==== Блинчик ====)\n= filling Плюх =\n= filling Грох =\n= sauce Мадрагора =\n(==== Блинчик ====)\n\nPrice: 170,000000\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt,actualReceipt);

    }
}
