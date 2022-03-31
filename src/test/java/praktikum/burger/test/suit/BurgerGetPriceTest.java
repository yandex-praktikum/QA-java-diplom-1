package praktikum.burger.test.suit;

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
public class BurgerGetPriceTest {
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient;

    @Test
    public void getPriceTest() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient);
        Mockito.when(testBun.getPrice()).thenReturn(42F);
        Mockito.when(testIngredient.getPrice()).thenReturn(15F);
        float actualBurgerPrice = testBurger.getPrice();
        Assert.assertEquals(99F, actualBurgerPrice, 99F - actualBurgerPrice);
    }
}