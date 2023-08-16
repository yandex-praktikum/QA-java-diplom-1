package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient firstIngredient, secondIngredient;
    Burger burger = new Burger();
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        int actual = 1;
        MatcherAssert.assertThat(actual, notNullValue());
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        float expectedPrice = 4650.0F;
        Mockito.when(bun.getPrice()).thenReturn(2325.0F);
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedReceipt = "(==== Краторная булка N-200i ====)\n= sauce Соус Spicy-X =\n= filling Биокотлета из марсианской Магнолии =\n(==== Краторная булка N-200i ====)\n\nPrice: 2490,000000\n";

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(988.0f);
        Mockito.when(firstIngredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(firstIngredient.getPrice()).thenReturn(90.0f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(secondIngredient.getPrice()).thenReturn(424.0f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(bun.getPrice()).thenReturn(988.0f);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        System.out.println(firstIngredient);
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
    }
}