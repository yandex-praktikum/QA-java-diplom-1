import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetBurgerPriceTest {

    private Bun bun;
    private Ingredient ingredient;
    private Ingredient ingredient1;

    private final float bunPrice;
    private final float ingredientPrice;
    private final float ingredient1Price;
    private final float expected;

    public GetBurgerPriceTest(float bunPrice, float ingredientPrice, float ingredient1Price, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredient1Price = ingredient1Price;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        ingredient1 = Mockito.mock(Ingredient.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {25.5f, 50.5f, 75.5f, 177},
                {0, 0, 0, 0},
                {-25.5f, -50.5f, -75.5f, -177}
        });
    }

    @Test
    public void testGetPrice(){
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient1.getPrice()).thenReturn(ingredient1Price);

        float actual = burger.getPrice();
        String message = "Метод getPrice неверно рассчитал стоимость: " + actual + ". Ожидаемая стоимость: " + expected;
        Assert.assertEquals(message, expected, actual, 0);
    }

}
