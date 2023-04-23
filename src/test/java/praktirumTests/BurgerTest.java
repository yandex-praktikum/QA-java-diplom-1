package praktirumTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientToBurgerTest() {
        ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientFromBurgerTest() {
        ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInBurgerTest() {
        ingredient = Mockito.mock(Ingredient.class);
        Ingredient ingredientTest = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTest);
        burger.moveIngredient(1, 0);
        assertEquals(ingredientTest, burger.ingredients.get(0));
    }

    @Test
    public void getPriceOfBurgerWithIngredientsTest() {
        Mockito.when(bun.getPrice()).thenReturn(101f);
        Mockito.when(ingredient.getPrice()).thenReturn(205f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(407, burger.getPrice(), 0.0);
    }

    @Test
    public void getPriceOfBurgerPriceWithoutIngredientTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        assertEquals(200.0f, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals("(==== Булка ====)\r\n= filling Котлета =\r\n(==== Булка ====)\r\n\r\n" +
                "Price: 400,000000\r\n", burger.getReceipt());
        System.out.println(burger.getReceipt());
    }
}
