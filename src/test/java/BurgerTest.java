import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunRed;
    @Mock
    Ingredient ingredientFilling;
    @Mock
    Ingredient ingredientSauce;

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFilling);
        assertTrue("Элемент не добавлен в бургер", burger.ingredients.contains(ingredientFilling));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bunRed);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        Mockito.when(bunRed.getPrice()).thenReturn(200f);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200f);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(200f);
        Assert.assertEquals(burger.getPrice(), 800, 1);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        List<Ingredient> ingredient = new ArrayList<>();
        ingredient.add(ingredientFilling);
        ingredient.add(ingredientSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(burger.ingredients, ingredient);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bunRed);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bunRed.getName()).thenReturn("red bun");
        Mockito.when(ingredientSauce.getName()).thenReturn("hot sauce");
        Mockito.when(ingredientFilling.getName()).thenReturn("cutlet");
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        String newGetReceipt = "(==== red bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling cutlet =\n" +
                "(==== red bun ====)\n" +
                "\n" +
                "Price: 0,000000" + "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(newGetReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));
    }
}

