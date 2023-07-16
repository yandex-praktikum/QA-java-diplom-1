package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient cutletFilling;
    @Mock
    Ingredient hotSauce;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void setBunsCreateBun(){
        burger.setBuns(bun);

        assertThat(burger.bun, is(notNullValue()));
    }
    @Test
    public void checkAddIngredient(){
        burger.addIngredient(cutletFilling);

        assertTrue(burger.ingredients.contains(cutletFilling));
    }
    @Test
    public void checkRemoveIngredient(){
        burger.addIngredient(hotSauce);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void checkMoveIngredient(){
        burger.addIngredient(cutletFilling);
        burger.addIngredient(hotSauce);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(hotSauce);
        ingredients.add(cutletFilling);

        burger.moveIngredient(0, 1);

        assertEquals(burger.ingredients, ingredients);
    }
    @Test
    public void getPriceReturnPrice(){
        burger.setBuns(bun);
        burger.addIngredient(cutletFilling);
        burger.addIngredient(hotSauce);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(cutletFilling.getPrice()).thenReturn(33F);
        Mockito.when(hotSauce.getPrice()).thenReturn(22F);

        assertEquals(burger.getPrice(), 75, 1);
    }

    @Test
    public void getReceiptReturnReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(cutletFilling);
        burger.addIngredient(hotSauce);
        Mockito.when(bun.getName()).thenReturn(" bun with black dust ");
        Mockito.when(cutletFilling.getName()).thenReturn("cutlet");
        Mockito.when(hotSauce.getName()).thenReturn("hot sauce");
        Mockito.when(cutletFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(hotSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(cutletFilling.getPrice()).thenReturn(50f);
        Mockito.when(hotSauce.getPrice()).thenReturn(30f);
        String newReceipt = "(====  bun with black dust  ====)\n" +
                            "= filling cutlet =\n" +
                            "= sauce hot sauce =\n" +
                            "(====  bun with black dust  ====)\n" +
                            "\n" +
                            "Price: 100,000000\n";

        String actualReceipt = burger.getReceipt();

        assertEquals(newReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));
    }

}
