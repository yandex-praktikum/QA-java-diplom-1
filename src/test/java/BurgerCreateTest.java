import config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerCreateTest extends TestConfig {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    List<Ingredient> ingredients = new ArrayList<>();

    @Mock
    List<Bun> buns = new ArrayList<>();

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(GET_PRICE_EXPECTED, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(50f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(GET_RECEIPT_EXPECTED, burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        Mockito.when(ingredients.get(0)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(FILLING, "cutlet", 100));
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        Ingredient actual = burger.ingredients.get(0);
        assertEquals(REMOVE_INGREDIENT_EXPECTED, actual);
    }

    @Test
    public void moveIngredientTest() {
        Mockito.when(ingredients.get(0)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        Mockito.when(ingredients.get(1)).thenReturn(new Ingredient(FILLING, "cutlet", 100));
        Mockito.when(buns.get(0)).thenReturn(new Bun("black bun", 100));
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);
        assertEquals(MOVE_INGREDIENT_EXPECTED, actual);
    }
}
