package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerGetPriceParametrizedTest {

    private final Bun bun;
    private final Ingredient[] ingredients;
    private final float expectedPrice;

    public BurgerGetPriceParametrizedTest(Bun bun, Ingredient[] ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Bun bun1 = mock(Bun.class);
        when(bun1.getPrice()).thenReturn(200f);

        Ingredient ingredient1_1 = mock(Ingredient.class);
        when(ingredient1_1.getPrice()).thenReturn(100f);

        Ingredient ingredient1_2 = mock(Ingredient.class);
        when(ingredient1_2.getPrice()).thenReturn(50f);

        Bun bun2 = mock(Bun.class);
        when(bun2.getPrice()).thenReturn(250f);

        Ingredient ingredient2_1 = mock(Ingredient.class);
        when(ingredient2_1.getPrice()).thenReturn(150f);

        Ingredient ingredient2_2 = mock(Ingredient.class);
        when(ingredient2_2.getPrice()).thenReturn(20f);

        return Arrays.asList(new Object[][]{
                {bun1, new Ingredient[]{ingredient1_1, ingredient1_2}, 550f},
                {bun2, new Ingredient[]{ingredient2_1, ingredient2_2}, 670f}
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Arrays.asList(ingredients).forEach(burger::addIngredient);

        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }
}
