package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void checkGetPriceReturnsPriceForBun(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200.0f);

        float expectedPrice=400.0f;
        Assert.assertEquals("Price is not equal expectedPrice for bun", expectedPrice, burger.getPrice(), 0);

    }

    @Test
    public void checkGetPriceReturnsPriceForBunAndIngredient(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(400.0f);

        float expectedPrice=1000.0f;
        Assert.assertEquals("Price is not equal expectedPrice for bun and ingredient", expectedPrice, burger.getPrice(), 0);

    }


}
