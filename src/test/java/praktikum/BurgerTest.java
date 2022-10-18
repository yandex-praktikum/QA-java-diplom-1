package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;
import static praktikum.BunAndIngredientsPrices.*;

import praktikum.BunAndIngredientsPrices;

public class BurgerTest {

    private Bun bun;

    private Ingredient ingredient_1;
    private Ingredient ingredient_2;
    private Ingredient ingredient_3;
    private Burger burger;

    public Burger createBurgerWith1BunAnd3Ingredients() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient_1);
        burger.addIngredient(ingredient_2);
        burger.addIngredient(ingredient_3);

        return burger;
    }

    @Before
    public void setUp() {
        bun = new Bun("tasty", BUN_PRICE);
        ingredient_1 = new Ingredient(IngredientType.SAUCE, "hot sauce", INGREDIENT_1_PRICE);
        ingredient_2 = new Ingredient(IngredientType.FILLING, "cutlet", INGREDIENT_2_PRICE);
        ingredient_3 = new Ingredient(IngredientType.FILLING, "dinosaur", INGREDIENT_3_PRICE);
        burger = new Burger();
    }

    @Test
    public void checkPriceOfBurgerAddingIngredients70() {
        createBurgerWith1BunAnd3Ingredients();
        float actualBurgerPrice = burger.getPrice();
        assertEquals("Цена подсчитана некорректно", BunAndIngredientsPrices.countPriceOfBurger(), actualBurgerPrice, 0);
        int actualNumberOfIngredients = burger.ingredients.size();
        assertEquals("Ингредиентов должно быть 3", 3, actualNumberOfIngredients);
    }

    @Test
    public void checkPriceOfBurgerRemoveIngredient50() {
        createBurgerWith1BunAnd3Ingredients();
        burger.removeIngredient(1);
        float actualBurgerPrice = burger.getPrice();
        assertEquals("Цена подсчитана некорректно", BunAndIngredientsPrices.countPriceOfBurgerWithoutSecondIngredient(), actualBurgerPrice, 0);
        int actualNumberOfIngredients = burger.ingredients.size();
        assertEquals("Ингредиентов должно быть 2", 2, actualNumberOfIngredients);
    }

    @Test
    public void checkPriceOfBurgerMove3rdIngredientTo2ndPosition() {
        createBurgerWith1BunAnd3Ingredients();
        List<Ingredient> ingredientsList = burger.ingredients;
        burger.moveIngredient(2,0);
        assertEquals("На позиции с индексом 0 должен стоять ингредиент №3",
                             ingredient_3,
                             ingredientsList.get(0));
        assertEquals("На позиции с индексом 1 должен стоять ингредиент №1",
                             ingredient_1,
                             ingredientsList.get(1));
        assertEquals("На позиции с индексом 2 должен стоять ингредиент №2",
                             ingredient_2,
                             ingredientsList.get(2));
    }

    @Test
    public void checkGetReceiptMethod() {
        createBurgerWith1BunAnd3Ingredients();
        String burgerReceipt = burger.getReceipt();
        System.out.println(burgerReceipt + "\n");
        assertThat(burgerReceipt, containsString("sauce hot sauce"));
        assertThat(burgerReceipt, containsString("filling cutlet"));
        assertThat(burgerReceipt, containsString("filling dinosaur"));
        assertThat(burgerReceipt, containsString("Price: 70,000000"));
    }
}
