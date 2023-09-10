package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger = new Burger();


//    @Mock
//    Ingredient ingredient = new Ingredient();

    @Test
    public void setBuns() {
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredient() {
    }

    @Test
    public void removeIngredient() {
    }

    @Test
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }
}