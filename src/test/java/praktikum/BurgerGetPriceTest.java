package praktikum;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceTest {

    float priceBun;
    float priceIngredient;
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun = RandomUtils.nextInt(5, 500));
        burger.setBuns(bun);
        float burgerBunPrice = priceBun * 2;
        Mockito.when(ingredient.getPrice()).thenReturn(priceIngredient = RandomUtils.nextInt(5, 500));
        int ingredientsAmount = RandomUtils.nextInt(1, 5);
        for (int i = 1; i <= ingredientsAmount; i++) {
            burger.addIngredient(ingredient);
        }
        float burgerIngredientPrice = priceIngredient * ingredientsAmount;
        float burgerPrice = burgerBunPrice + burgerIngredientPrice;
        assertEquals(burgerPrice, burger.getPrice(), 0);
    }

}
