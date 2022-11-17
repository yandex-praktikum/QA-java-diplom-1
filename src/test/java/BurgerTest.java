import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public Burger burger;
    public Database database;
    @Mock
    public Bun bun;
    @Mock
    public Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
    }

    @Test
    public void getPrice() {
        burger.bun = bun;
        burger.ingredients = Arrays.asList(ingredient, ingredient, ingredient);
        Mockito.when(bun.getPrice()).thenReturn(database.availableBuns().get(0).getPrice());
        Mockito.when(ingredient.getPrice()).thenReturn(database.availableIngredients().get(0).getPrice());
        float result = burger.getPrice();
        Assert.assertEquals(500.0f, result, 0.2f);
    }

    @Test
    public void getReceipt() {
        burger.bun = bun;
        burger.ingredients = Arrays.asList(ingredient, ingredient, ingredient);
        Mockito.when(bun.getName()).thenReturn(database.availableBuns().get(0).getName());
        Mockito.when(ingredient.getName()).thenReturn(database.availableIngredients().get(0).getName());
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        String result = burger.getReceipt();
        Assert.assertEquals("(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= sauce hot sauce =\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 0,000000\n", result);
    }
}