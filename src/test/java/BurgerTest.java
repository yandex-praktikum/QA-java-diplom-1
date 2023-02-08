import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    List<Ingredient> ingredients;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        ingredients = new ArrayList<>();
        ingredients.add(ingredientSauce);
        ingredients.add(ingredientFilling);
        burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients = ingredients;
    }

    @Test
    public void checkAddIngredient() {
        assertEquals(2, ingredients.size());
    }

    @Test
    public void checkGetPrice() {
        when(bun.getPrice()).thenReturn(100f);
        when(ingredientSauce.getPrice()).thenReturn(100f);
        when(ingredientFilling.getPrice()).thenReturn(100f);
        assertEquals(400f, burger.getPrice(), 0.00);

    }

    @Test
    public void checkRemoveIngredient() {
        burger.removeIngredient(1);
        Assert.assertEquals(1, ingredients.size());

    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Bun");
        when(ingredientSauce.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientSauce.getName()).thenReturn("ingredientSauce");
        when(ingredientFilling.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientFilling.getName()).thenReturn("ingredientFilling");
        String expected = "(==== Bun ====)\n" +
                "= filling ingredientSauce =\n" +
                "= sauce ingredientFilling =\n" +
                "(==== Bun ====)\n" +
                "\nPrice: 0,000000\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}