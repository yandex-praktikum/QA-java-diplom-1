package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceEquals250() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(100));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(50));

        float expected = 250;
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptEqualsExpected() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        burger.removeIngredient(1);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(burger.getPrice()).thenReturn(Float.valueOf(500));

        String expected = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 500,000000\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }
}
