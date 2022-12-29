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

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock1;

    @Mock
    Ingredient ingredientMock2;

    @Mock
    Ingredient ingredientMock3;

    @Test
    public void getBurgerPriceTest(){
        Mockito.when(bunMock.getPrice()).thenReturn(500.0f);
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.getPrice();
        Mockito.verify(bunMock, Mockito.times(1)).getPrice();
        Assert.assertEquals(1000.0f, burger.getPrice(), 0);
    }

    @Test
    public void getBurgerPriceWithIngredientTest(){
        Mockito.when(bunMock.getPrice()).thenReturn(10.3f);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(5.0f);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(4.0f);
        Mockito.when(ingredientMock3.getPrice()).thenReturn(3.0f);
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.ingredients = new ArrayList<>(Arrays.asList(ingredientMock1, ingredientMock2, ingredientMock3));
        burger.getPrice();
        Mockito.verify(bunMock, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock1, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock2, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock3, Mockito.times(1)).getPrice();
        Assert.assertEquals(32.6f, burger.getPrice(), 0);
    }

    @Test
    public void addIngredientBurgerTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        Assert.assertEquals(3, burger.ingredients.size());
        System.out.println("Добавились " + burger.ingredients);
    }

    @Test
    public void removeIngredientBurgerTest(){
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(Arrays.asList(ingredientMock1, ingredientMock2, ingredientMock3));
        burger.removeIngredient(1);
        Assert.assertEquals(2,burger.ingredients.size());
        System.out.println("Удалили Ingredient2 " + burger.ingredients);
    }

    @Test
    public void moveIngredientBurgerTest(){
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(Arrays.asList(ingredientMock1, ingredientMock2, ingredientMock3));
        burger.moveIngredient(2,0);
        Assert.assertEquals( new ArrayList<>(Arrays.asList(ingredientMock3, ingredientMock1, ingredientMock2)), burger.ingredients);
        System.out.println("Переставили Ingredient3 на первое место " + burger.ingredients);
    }

    @Test
    public void getReceiptBurgerTest(){
        Burger burger = new Burger();
        Bun bun = new Bun("Булка с кунжутом", 2.45f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Говяжья котлетка", 31.90f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Дорогущий майонез", 359.90f);
        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        System.out.println(burger.getReceipt());
        Assert.assertEquals(396.7, burger.getPrice(), 0.001);
    }
}
