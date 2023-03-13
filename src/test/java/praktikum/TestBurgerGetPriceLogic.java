package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestBurgerGetPriceLogic {
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient1;
    @Mock
    Ingredient testIngredient2;

    @Test
    public void checkBurgerGetPriceLogic() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient1);
        testBurger.addIngredient(testIngredient2);

        testBurger.getPrice();
        Mockito.verify(testBun, Mockito.times(1)).getPrice();
        Mockito.verify(testIngredient1, Mockito.times(1)).getPrice();
        Mockito.verify(testIngredient2, Mockito.times(1)).getPrice();
    }

    @Test
    public void checkBurgerGetPriceLogic2() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient1);
        testBurger.addIngredient(testIngredient2);

        Mockito.when(testBun.getPrice()).thenReturn(10.00F);
        Mockito.when(testIngredient1.getPrice()).thenReturn(10.00F);
        Mockito.when(testIngredient2.getPrice()).thenReturn(10.00F);
        Assert.assertEquals( 40.00F, testBurger.getPrice(),0.0F);
    }
}
