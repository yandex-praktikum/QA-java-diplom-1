package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("setBunsTest() didn't set buns", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertNotNull("addIngredientTest() didn't add an ingredient", burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        int expected = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size()-1);
        assertEquals("removeIngredientTest() didn't remove an ingredient", expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ингридиент", 34);
        Ingredient newIngredient = new Ingredient(SAUCE, "Новый Ингридиент", 26);
        List<Ingredient> expected = List.of(newIngredient, ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0,1);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("moveIngredientTest() didn't move an ingredient", expected, actual);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        float actual = burger.getPrice();
        float expected = 3f;
        assertEquals("getPriceTest() returned an invalid value", expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Грибной соус");
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0f);

        String expectedReceipt = String.format("(==== Краторная булка ====)%n") +
                String.format("= Грибной соус =%n") +
                String.format("(==== Краторная булка ====)%n") +
                String.format("%nPrice: 1050.000000%n");
        String actualReceipt = burger.getReceipt();
        assertEquals("getReceipt() returned an invalid value", expectedReceipt, actualReceipt);
    }
}
