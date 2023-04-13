import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamsUnitTest {

    private final float bunPrice;
    private final float meatPrice;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private final double delta = 0;

    public BurgerParamsUnitTest(float bunPrice, float meatPrice) {
        this.bunPrice = bunPrice;
        this.meatPrice = meatPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getTestPrice() {
        return new Object[][]{
                {5f, 31f},
                {13.45f, 50.5f},
                {9.7f, 5.54f}
        };
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(meatPrice);
        float expectedPrice = 2 * bunPrice + meatPrice;
        assertEquals("У бургера должна быть фиксированная цена", expectedPrice, burger.getPrice(), delta);
    }
}