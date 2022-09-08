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
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBurgerGetPriceTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    private final float bunPrice;
    private final float ingredientPrice_1;
    private final float ingredientPrice_2;
    private final float expected;

    public ParameterizedBurgerGetPriceTest(float bunPrice, float ingredientPrice_1, float ingredientPrice_2, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice_1 = ingredientPrice_1;
        this.ingredientPrice_2 = ingredientPrice_2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {100, 200, 300, 700},
                {200, 0, 200, 600},
                {1.02F, 10.5F, 10, 22.54F},
                {0, 111, 100000, 100111},
        };
    }

    @Mock
    Ingredient ingredient_1 = new Ingredient(IngredientType.FILLING, "sausage", 200);
    @Mock
    Ingredient ingredient_2 = new Ingredient(IngredientType.SAUCE, "hot sauce", 0);
    @Mock
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getPriceReturnsCorrectPrice() {
        Burger burger = new Burger();
        burger.bun = this.bun;
        burger.ingredients.add(ingredient_1);
        burger.ingredients.add(ingredient_2);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient_1.getPrice()).thenReturn(ingredientPrice_1);
        Mockito.when(ingredient_2.getPrice()).thenReturn(ingredientPrice_2);

        float actual = burger.getPrice();

        assertEquals("Returns price is not equals expected", expected, actual, 0);
    }
}
