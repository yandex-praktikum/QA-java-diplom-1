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
public class BurgerTest {
    @Mock
    Bun mBun;
    @Mock
    Burger mBurger;
    @Mock
    Ingredient mIngredient;
    @Test
    public void testBurgerSetBunsMethod(){
        mBurger.setBuns(mBun);
        Mockito
                .verify(mBurger,Mockito.times(1))
                .setBuns(Mockito.any(Bun.class));
    }
    @Test
    public void testBurgerAddIngredientMethod(){
        mBurger.addIngredient(mIngredient);
        Mockito
                .verify(mBurger,Mockito.times(1))
                .addIngredient(Mockito.any(Ingredient.class));
    }
    @Test
    public void testBurgerRemoveIngredientMethod(){
        mBurger.removeIngredient(0);
        Mockito
                .verify(mBurger,Mockito.times(1))
                .removeIngredient(Mockito.anyInt());
    }
    @Test
    public void testBurgerMoveIngredientMethod(){
        mBurger.moveIngredient(0,1);
        Mockito
                .verify(mBurger,Mockito.times(1))
                .moveIngredient(Mockito.anyInt(),Mockito.anyInt());
    }
    @Test
    public void testBurgerGetPriceMethod(){
        mBurger.getPrice();
        Mockito
                .verify(mBurger,Mockito.times(1))
                .getPrice();
    }
    @Test
    public void testBurgerGetReceipt(){
        mBurger.getReceipt();
        Mockito
                .verify(mBurger,Mockito.times(1))
                .getReceipt();
    }
}
