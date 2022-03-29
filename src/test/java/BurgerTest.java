import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsTest() {
        Bun expected = bun;
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals(expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals("Количество ингредиентов не совпадает", 2, burger.ingredients.size());
        assertEquals("Ингредиенты не совпадают", expected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> expected = Arrays.asList(ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);

        assertEquals("Количество ингредиентов не совпадает", 1, burger.ingredients.size());
        assertEquals("Ингредиенты не совпадают", expected, burger.ingredients);

        burger.removeIngredient(0);

        assertEquals("Количество ингредиентов не совпадает", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientWithChangeTest() {
        List<Ingredient> expected = Arrays.asList(ingredient2, ingredient1);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int expectedSize = burger.ingredients.size();
        burger.moveIngredient(0, 1);

        assertEquals("Количество ингредиентов не совпадает", expectedSize, burger.ingredients.size());
        assertEquals("Порядок ингредиентов не совпадает", expected, burger.ingredients);
    }

    @Test
    public void moveIngredientWithoutChangeTest() {
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int expectedSize = burger.ingredients.size();
        burger.moveIngredient(0, 0);

        assertEquals("Количество ингредиентов не совпадает", expectedSize, burger.ingredients.size());
        assertEquals("Порядок ингредиентов не совпадает", expected, burger.ingredients);
    }

    @Test
    public void getPriceAllTest() {
        float priceBun = (float) 120.05;
        float priceFilling = (float) 240.5;
        float priceSauce = 58;
        float expected = 2 * priceBun + priceFilling + priceSauce;

        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Мясо", priceFilling);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Соус", priceSauce);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float actual = burger.getPrice();

        assertEquals("Цены не совпадают", expected, actual, 0);
    }

    @Test
    public void getPriceWithoutIngredientsTest() {
        float priceBun = (float) 120.05;
        float expected = 2 * priceBun;

        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        burger.setBuns(bun);
        float actual = burger.getPrice();

        assertEquals("Цены не совпадают", expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        float priceBun = (float) 120.05;
        float priceFilling = (float) 240.5;
        float priceSauce = 58;

        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Мясо", priceFilling);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Соус", priceSauce);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(bun.getName()).thenReturn("Булка");

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expected = "(==== " + burger.bun.getName() + " ====)\n" +
                "= " + burger.ingredients.get(0).getType().toString().toLowerCase() + " " + burger.ingredients.get(0).getName() + " =\n" +
                "= " + burger.ingredients.get(1).getType().toString().toLowerCase() + " " + burger.ingredients.get(1).getName() + " =\n" +
                "(==== " + burger.bun.getName() + " ====)\n" +
                "\n" +
                "Price: " + String.format("%f", burger.getPrice()) + "\n";

        String actual = burger.getReceipt();

        assertEquals("Рецепты не совпадают", expected, actual);
    }
}