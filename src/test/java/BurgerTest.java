import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Burger burger;

    @Spy
    Database database = new Database();

    @Test
    public void checkAddBunInBurgerWithCorrectDataPositive(){
        Bun bun = database.availableBuns().get(0);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void checkAddIngredientsWithCorrectDataPositive(){
        Ingredient ingredient = database.availableIngredients().get(1);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void checkAddTwoIngredientsWithCorrectDataPositive(){
        Ingredient ingredient = null;
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(2)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientsFromListPositive(){
        Ingredient ingredient1 = database.availableIngredients().get(0);
        Ingredient ingredient2 = database.availableIngredients().get(3);
        Collections.addAll(burger.ingredients, ingredient1, ingredient2);
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(2)).removeIngredient(0);
    }

    @Test
    public void getBurgerPricePositive(){
        Bun bun = database.availableBuns().get(0);
        Ingredient ingredient1 = database.availableIngredients().get(2);
        Ingredient ingredient2 = database.availableIngredients().get(4);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.getPrice();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
        Assert.assertEquals("Цена отличается от заданной", 700.0f, burger.getPrice(), 0.01f);
    }

    @Test
    public void getBurgerReceiptPositive(){
        Bun bun = database.availableBuns().get(0);
        Ingredient ingredient1 = database.availableIngredients().get(2);
        Ingredient ingredient2 = database.availableIngredients().get(4);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "= filling dinosaur =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 700,000000\r\n";
        System.out.println(burger.getReceipt());
        System.out.println(expectedReceipt);
        Assert.assertEquals("Рецепт не совпадает с ожидаемым", expectedReceipt, burger.getReceipt());
    }
}
