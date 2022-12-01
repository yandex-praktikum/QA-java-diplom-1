package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngredient0;
    @Mock
    Ingredient mockIngredient1;
    Burger burger = new Burger();

    @Test
    public void setBuns() {
        burger.setBuns(mockBun);
        burger.bun.getName();
        Mockito.verify(mockBun).getName();
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(mockIngredient0);
        burger.ingredients.get(0).getName();
        Mockito.verify(mockIngredient0).getName();
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(mockIngredient0);
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        burger.ingredients.get(0).getName();
        Mockito.verify(mockIngredient1).getName();
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(mockIngredient0);
        burger.addIngredient(mockIngredient1);
        burger.moveIngredient(0,1);
        burger.ingredients.get(0).getName();
        Mockito.verify(mockIngredient1).getName();
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }
}