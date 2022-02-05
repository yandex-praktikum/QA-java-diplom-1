package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    List<Ingredient> ingredients;

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Buns are not equal",
                bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        Mockito.verify(burger.ingredients).add(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients = ingredients;
        burger.removeIngredient(0);
        Mockito.verify(burger.ingredients).remove(0);
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients = ingredients;
        burger.moveIngredient(0, 1);
        Mockito.verify(burger.ingredients).add(1, ingredients.remove(0));
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            ingredients.add(ingredient);
        }

        float bunPrice = 42.99f;
        float ingredientPrice = 51.00f;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        for (int i = 0; i < ingredients.size(); i++) {
            Mockito.when(ingredients.get(i).getPrice()).thenReturn(ingredientPrice);
        }
        float actualPrice = burger.getPrice();
        float expectedPrice = bunPrice * 2 + ingredientPrice * ingredients.size();
        assertEquals("Prices are not equal",
                expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        String bunName = "Rue bun";
        float bunPrice = 42.99f;
        IngredientType ingredientType = IngredientType.SAUCE;
        String ingredientName = "Mayonnaise";
        float ingredientPrice = 55.00f;

        burger.bun = bun;
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName, ingredientType.toString().toLowerCase(), ingredientName, bunName,
                (bunPrice * 2 + ingredientPrice));
        Assert.assertEquals("Receipts are not equal",
                expectedReceipt, actualReceipt);
    }
}
