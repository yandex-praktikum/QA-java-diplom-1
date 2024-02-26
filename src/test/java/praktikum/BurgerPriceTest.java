package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private final float bun;
    private final List<Float> ingredient;
    private final float expected;

    public BurgerPriceTest(float bun, List<Float> ingredient, float expected) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] generateData() {
        return new Object[][]{
                {1f, List.of(1f, 2f, 0.5f, 11.11f), 16.61f},
                {2f, List.of(4f, 1f, 0.55f), 9.55f},
                {0.25f, List.of(), 0.5f},
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Bun buns = mock(Bun.class);
        when(buns.getPrice()).thenReturn(bun);
        burger.setBuns(buns);
        ingredient.forEach(price -> {
            Ingredient ingredient = mock(Ingredient.class);
            when(ingredient.getPrice()).thenReturn(price);
            burger.addIngredient(ingredient);
        });
        float price = burger.getPrice();
        assertEquals("Wrong price", expected, price, 0f);
    }
}
