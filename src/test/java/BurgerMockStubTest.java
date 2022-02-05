import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockStubTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Burger burger;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(Mockito.anyInt());
        Mockito.verify(burger).removeIngredient(Mockito.anyInt());
    }

    @Test
    public void moveIngredient() {
        burger.moveIngredient(Mockito.anyInt(), Mockito.anyInt());
        Mockito.verify(burger).moveIngredient(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void getPrice() {
        Mockito.when(burger.getPrice()).thenReturn(1000.00F);
        assertEquals(1000.000, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.getReceipt();
        burger.getReceipt();
        burger.getReceipt();
        Mockito.verify(burger, Mockito.times(3)).getReceipt();
    }

}
