package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    Ingredient ingredient;
    Bun bun = new Bun("black bun", 100);


    @Test
    public void addIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        //Act
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        int actual = burger.ingredients.size();
        int expected = 2;
        String actualName = burger.ingredients.get(0).name;
        float actualPrice = burger.ingredients.get(0).price;
        IngredientType actualType = burger.ingredients.get(0).type;
        //Assert
        assertEquals("Длина списков не совпадает",expected, actual);
        assertEquals("Название элемента не совпадает", "hot sauce", actualName);
        assertEquals("Стоимость не совпадает", 100, actualPrice, 0);
        assertEquals("Соус не совпадает", IngredientType.SAUCE, actualType);


    }

    @Test
    public void removeIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        //Act
        burger.removeIngredient(1);
        burger.removeIngredient(1);
        int actual = burger.ingredients.size();
        int expected = 1;
        //Assert
        assertEquals("Длина списков не совпадает",expected, actual);

    }

    @Test
    public void moveIngredientTest() {
        //Arrange
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        //Act
        burger.moveIngredient(3,0);
        burger.moveIngredient(4,2);
        String actualName = burger.ingredients.get(0).name;
        String actualName2 = burger.ingredients.get(2).name;
        //Assert
        assertEquals("Название ингредиента котлета не совпадает", "cutlet", actualName);
        assertEquals("Название элемента динозавр не совпадает", "dinosaur", actualName2);

    }

    @Test
    public void getPrice() {
        //Arrange
        List<Ingredient> ingredients = new ArrayList<>();
        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        //Act
        float price = bun.getPrice()*2;
        float expectedPrice = 300;
        float actualPrice = burger.getPrice();
        //Assert
        assertEquals("Расчитанная цена не совпадает", expectedPrice, actualPrice, 0);
        System.out.println(burger.getPrice());

    }

    @Test
    public void getReceipt() {
        //Arrange
        List<Ingredient> ingredients = new ArrayList<>();
        Burger burger = new Burger();
        burger.setBuns(bun);
        ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        //Act
        String actualReceipt  = burger.getReceipt();
        StringBuilder expextedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "black bun"));
        expextedReceipt.append(String.format("= %s %s =%n", "sauce","hot sauce"));
        expextedReceipt.append(String.format("= %s %s =%n", "filling","cutlet"));
        expextedReceipt.append(String.format("(==== %s ====)%n", "black bun"));
        expextedReceipt.append(String.format("%nPrice: %f%n", 400.0));
        //Assert
        assertEquals("Рецепт не совпадает!", expextedReceipt.toString(),actualReceipt);

    }
}