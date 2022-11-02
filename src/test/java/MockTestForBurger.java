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
public class MockTestForBurger {
    @Mock
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void mockTestForSetBuns(){
        burger.setBuns(bun);
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(2)).setBuns(bun);
    }

    @Test
    public void mockTestForAddIngredients(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(4)).addIngredient(ingredient);
    }

    @Test
    public void mockTestForRemoveIng(){
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(0);
    }
    @Test
    public void testBurgerTest(){
        Mockito.when(burger.getPrice()).thenReturn(1000.00F);
        float price = burger.getPrice();
        assertEquals(1000.00F,price,0);
    }

}
