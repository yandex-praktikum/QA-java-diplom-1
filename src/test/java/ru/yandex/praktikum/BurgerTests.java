package ru.yandex.praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static ru.yandex.praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    Burger burger;

    Database database = new Database();
    @Mock
    Bun bun;
    @Mock
    Ingredient otherIngredient;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        int expected = 1;
        burger.addIngredient(ingredient);
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        int expected = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.addAll(Arrays.asList(ingredient, otherIngredient));
        List<Ingredient> actual = new ArrayList<>(Arrays.asList(otherIngredient, ingredient));
        burger.moveIngredient(0, 1);
        assertEquals(actual, burger.ingredients);
    }

    @Test
    public void getPriceBurgerTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getPrice()).thenReturn(200F);
        when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(500, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("Сладкая булочка");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getPrice()).thenReturn(500F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void burgerTest() {
        List<Bun> buns = database.availableBuns();
        var bun = buns.get(new Random().nextInt(buns.size()));
        List<Ingredient> ingredients = database.availableIngredients();
        var ingredient = ingredients.get(new Random().nextInt(ingredients.size()));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(bun.getPrice()*2+ingredient.getPrice(), burger.getPrice(), 0);
    }
}