import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.mockito.Mockito.*;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(ingredient.getPrice()).thenReturn(10F);
        Mockito.when(bun.getPrice()).thenReturn(5F);
        burger = new Burger();
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void checkAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void checkRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }


    @Test
    public void checkMoveIngredient() {
        String name = "mock";
        Ingredient mock = mock(Ingredient.class, withSettings().name(name));
        burger.addIngredient(ingredient);
        burger.addIngredient(mock);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(0).toString(), name);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger = new Burger();
        String nameBun = "bulka";
        String nameIngredient = "tomato";
        IngredientType ingredientType = FILLING;
        String expectedReceipt = String.format("(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                nameBun, ingredientType.toString().toLowerCase(), nameIngredient, nameBun, (ingredient.getPrice()+(bun.getPrice()*2)));
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(nameBun);
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn(nameIngredient);
        when(ingredient.getType()).thenReturn(ingredientType);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void checkGetPrice() {
        float price = new Random().nextFloat();;
        float expectedPrice = price * 2 + price;
        when(bun.getPrice()).thenReturn(price);
        when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertTrue(expectedPrice == burger.getPrice());
    }
}
