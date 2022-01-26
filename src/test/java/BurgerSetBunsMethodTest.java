import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

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
public class BurgerSetBunsMethodTest{
    Bun mBun;
    Burger mBurger;
    @Test
    public void testBurgerSetBunsMethod(){
        mBurger.setBuns(mBun);
        Mockito
                .verify(mBurger,Mockito.times(1))
                .setBuns(Mockito.any(Bun.class));
    }
}
