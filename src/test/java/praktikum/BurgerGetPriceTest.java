package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private final float bunPrice;
    private final List<Float> ingredientPrices;
    private final float expectedPrice;

    public BurgerGetPriceTest(float bunPrice, List<Float> ingredientPrices, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void verifyGetPrice() {
        // given
        Burger burger = new Burger();

        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);

        ingredientPrices.forEach(price -> {
            Ingredient ingredient = mock(Ingredient.class);
            when(ingredient.getPrice()).thenReturn(price);
            burger.addIngredient(ingredient);
        });

        // when
        float price = burger.getPrice();

        // then
        assertEquals(expectedPrice, price, 0f);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {1.5f, List.of(1f, 2.5f, 0.1f, 12.13f), 18.73f},
                {1f, List.of(4f, 0.5f, 1f), 7.5f},
                {0.25f, List.of(), 0.5f},
        };
    }
}
