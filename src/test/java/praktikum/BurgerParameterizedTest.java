package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;


@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private float bunPrice;
    private float ingredientPrice;
    private float expectedBurgerPrice;
    private Burger burger;


    public BurgerParameterizedTest(float bunPrice, float ingredientPrice,float expectedBurgerPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedBurgerPrice = expectedBurgerPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceParameters() {
        return new Object[][]{
                {10f, 25.5f, 45.5f},
                {15.5f, 30f, 61f},
                {14.6f, 0f, 29.2f},
                {0f, 15.6f, 15.6f},
                {0f, 0f, 0f},
                {-10f, -1.4f, -21.4f}
        };
    }

    @Before
    public void prepareData() {
        burger = new Burger();
    }

    @Test
    public void getPriceReturnCorrectBurgerPrice(){
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualBurgerPrice = burger.getPrice();

        Assert.assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0);
    }
}
