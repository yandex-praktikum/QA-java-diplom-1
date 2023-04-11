import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    private final float bun_price;
    private final float ingredient1_price;
    private final float ingredient2_price;
    private final float burger_price;

    public BurgerParameterizedTest(float bun_price, float ingredient1_price, float ingredient2_price, float burger_price) {
        this.bun_price = bun_price;
        this.ingredient1_price = ingredient1_price;
        this.ingredient2_price = ingredient2_price;
        this.burger_price = burger_price;
    }

    @Parameterized.Parameters
    public static Object[][] dataPriceOfIngredients() {
        return new Object[][]{
                {100.0f, 200.0f, 300.0f, 700.0f},
                {100.1f, 200.0f, 300.0f, 700.2f},
        };
    }
    @Test
    public void testBurgerPrice() {
        when(bun.getPrice()).thenReturn(bun_price);
        when(ingredient1.getPrice()).thenReturn(ingredient1_price);
        when(ingredient2.getPrice()).thenReturn(ingredient2_price);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertThat("Incorrect price for the ingredient", burger.getPrice(), is(burger_price));
    }

}
