import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {





    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Burger burger;


    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expected = 700f;
        assertEquals(expected, burger.getPrice(), 0.0f);
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
        String expected = "(==== black bun ====)\r\n" +
                          "= filling cutlet =\r\n" +
                          "(==== black bun ====)\r\n" +
                          "\r\n" +
                          "Price: 200,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}
