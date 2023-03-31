package ru.yandex.praktikum.diplom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerTest {
    public float bunPrice;
    public float ingredientPrice;
    public float fullPrice;
    @Mock
    Bun mockedBun;
    @Mock
    Ingredient mockedIngredientFirst;
    @Mock
    Ingredient mockedIngredientSecond;
    @Mock
    IngredientType mockedIngredientType;
    @Spy
    Burger spyBurger = new Burger();

    public BurgerTest(float bunPrice, float ingredientPrice, float fullPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.fullPrice = fullPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.TEST_DATA_FOR_BURGER_TEST;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBunsFieldBunContainsBunTypeObject() {
        Burger burger = new Burger();
        burger.setBuns(mockedBun);
        //Mockito.when(mockedBun.getKittens()).thenReturn(1);
        //Bun expected = mockedBun;
        Bun actual = burger.bun;
        //System.out.println(actual instanceof Bun);
        assertTrue("В боле bun записан не тип Bun", actual instanceof Bun);
    }

    @Test
    public void addIngredientLengthListIncreasesByOne() {
        Burger burger = new Burger();
        burger.addIngredient(mockedIngredientFirst);
        int expected = 1;
        int actual = burger.ingredients.size();
        assertEquals("Неверное значение количества ингредиентов", expected, actual);
    }

    @Test
    public void removeIngredientLengthListReducedByOne() {
        Burger burger = new Burger();
        //burger.addIngredient(mockedIngredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockedIngredientFirst);
        burger.ingredients = ingredients;
        burger.removeIngredient(0);
        int expected = 0;
        int actual = burger.ingredients.size();
        assertEquals("Неверное значение количества ингредиентов", expected, actual);
    }

    @Test
    public void moveIngredientIngredientsHaveBeenSwapped() {
        Burger burger = new Burger();
        //burger.addIngredient(mockedIngredient);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockedIngredientFirst);
        ingredients.add(mockedIngredientSecond);
        burger.ingredients = ingredients;
        //System.out.println(burger.ingredients);
        burger.moveIngredient(1, 0);
        //System.out.println(burger.ingredients);
        Ingredient expected = mockedIngredientSecond;
        Ingredient actual = burger.ingredients.get(0);
        assertEquals("Ингредиенты не поменялись местами", expected, actual);
    }

    @Test
    public void getPriceReturnPricePositiveResult() {
        Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockedIngredientFirst);
        burger.bun = mockedBun;
        burger.ingredients = ingredients;
        //float bunPrice = bunPrice;
        //float ingredientPrice = ingredientPrice;
        Mockito.when(mockedBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockedIngredientFirst.getPrice()).thenReturn(ingredientPrice);
        System.out.print(burger.getPrice());
        float expected = fullPrice;
        float actual = burger.getPrice();
        assertEquals("Неверная цена", expected, actual, 0);
    }

    @Test
    public void getReceipt() {
        //Burger burger = new Burger();
        List<Ingredient> ingredients = new ArrayList<>();
        float burgerPrice = 9;
        ingredients.add(mockedIngredientFirst);
        spyBurger.bun = mockedBun;
        spyBurger.ingredients = ingredients;
        Mockito.when(mockedBun.getName()).thenReturn("black bun");
        Mockito.when(mockedIngredientFirst.getName()).thenReturn("sour cream");
        Mockito.when(mockedIngredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(spyBurger.getPrice()).thenReturn(burgerPrice);
        String expected = "(====blackbun====)=saucesourcream=(====blackbun====)Price:9,000000";
        String actual = spyBurger.getReceipt().replaceAll("\\s+", "");
        //System.out.println(actual);
        //System.out.println(expected);
        //System.out.println(expected.equals(actual));
        assertEquals("Неверный рецепт", expected, actual);
    }


}
