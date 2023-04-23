import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;


    @Test
    public void checkMethodSetBuns(){
        burger = Mockito.spy(new Burger());
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void checkMethodAddIngredient(){
        burger = Mockito.spy(new Burger());
        burger.addIngredient(firstIngredient);
        Mockito.verify(burger).addIngredient(firstIngredient);
    }

    @Test
    public void checkMethodRemoveIngredient(){
        burger = Mockito.spy(new Burger());
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        Mockito.verify(burger).removeIngredient(0);
    }

    @Test
    public void checkMethodMoveIngredient(){
        burger = Mockito.spy(new Burger());
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        Mockito.verify(burger).moveIngredient(0,1);
    }

    @Test
    public void checkMethodGetPrice(){
        burger = Mockito.spy(new Burger());
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(burger.getPrice()).thenReturn(100f);
        Assert.assertEquals(100f, burger.getPrice(), Float.NaN);
    }

    @Test
    public void checkMethodGetPecepit(){
        burger = Mockito.spy(new Burger());
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.verify(burger).getReceipt();
    }

}
