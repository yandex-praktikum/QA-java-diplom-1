package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;


    @Test
    public void addIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chilli sour", 200);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredient);

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> actualIngredients = burger.ingredients;

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void removeIngredient() {
        Ingredient ingredientOne = new Ingredient(IngredientType.SAUCE, "chilli sour", 200);
        Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "beef", 400);

        List<Ingredient> expectedIngredients = new ArrayList<>(1);
        expectedIngredients.add(ingredientTwo);

        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        burger.removeIngredient(0);

        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(1, actualIngredients.size());
        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void moveIngredient() {
        Ingredient ingredientOne = new Ingredient(IngredientType.SAUCE, "chilli sour", 200);
        Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "beef", 400);

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(ingredientTwo);
        expectedIngredients.add(ingredientOne);

        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        burger.moveIngredient(1, 0);

        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    public void getPrice() {
        float ingredientOnePrice = 200f;
        float ingredientTwoPrice = 400f;
        Ingredient ingredientOne = new Ingredient(IngredientType.SAUCE, "chilli sour", ingredientOnePrice);
        Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "beef", ingredientTwoPrice);
        float bunPrice = 200F;

        float expectedPrice = bunPrice * 2 + ingredientOnePrice + ingredientTwoPrice;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceipt() {
        float ingredientOnePrice = 200f;
        float ingredientTwoPrice = 400f;
        IngredientType ingredientOneType = IngredientType.SAUCE;
        IngredientType ingredientTwoType = IngredientType.FILLING;
        String ingredientOneName = "chilli sour";
        String ingredientTwoName = "beef";
        String bunName = "grey bun";
        float bunPrice = 200F;
        float burgerPrice = bunPrice * 2 + ingredientOnePrice + ingredientTwoPrice;

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientOne.getName()).thenReturn(ingredientOneName);
        Mockito.when(ingredientOne.getPrice()).thenReturn(ingredientOnePrice);
        Mockito.when(ingredientOne.getType()).thenReturn(ingredientOneType);
        Mockito.when(ingredientTwo.getName()).thenReturn(ingredientTwoName);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(ingredientTwoPrice);
        Mockito.when(ingredientTwo.getType()).thenReturn(ingredientTwoType);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientOneType.toString().toLowerCase(), ingredientOneName));
        expectedReceipt.append(String.format("= %s %s =%n", ingredientTwoType.toString().toLowerCase(), ingredientTwoName));
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %f%n", burgerPrice));

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        System.out.println(expectedReceipt);

        String actualReceipt = burger.getReceipt();
        System.out.println(actualReceipt);

        assertEquals(expectedReceipt.toString(), actualReceipt);
    }
}