import org.junit.Assert;
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

@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedBurgerPrice;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;

    public BurgerPriceTest(float bunPrice, float ingredientPrice, float expectedBurgerPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedBurgerPrice = expectedBurgerPrice;
    }

    @Parameterized.Parameters(name = "Bun price = {0}; ingredient price = {1}; expected burger price {2} ")
    public static Object[][] getData() {
        return new Object[][]{
                {0.0f, 0.0f, 0.0f},
                {0.001f, 0.001f, 0.003f},
                {0.0f, 0.001f, 0.001f},
                {0.001f, 0.0f, 0.002f},
        };
    }

    @Test
    public void checkThatBurgerPriceCalculates() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(expectedBurgerPrice, burger.getPrice(), 0.0f);
    }
}
