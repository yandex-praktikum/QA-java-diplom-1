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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(Parameterized.class)
public class BurgerPriceParametrizedTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    private final float bun_price;
    private final float ingredient_price;
    private final float ingredient2_price;
    private final float burger_price;

    public BurgerPriceParametrizedTest(float bun_price, float ingredient_price, float ingredient2_price, float burger_price) {
        this.bun_price = bun_price;
        this.ingredient_price = ingredient_price;
        this.ingredient2_price = ingredient2_price;
        this.burger_price = burger_price;
    }

    @Parameterized.Parameters(name = "{index}:Стоимость бургера с булкой по цене = {0}  и ингредиентам  по цене = {1} и {2} : {3}")
    public static Object[][] ingredientsPriceData() {
        return new Object[][]{
                { 100.0f, 200.0f, 300.0f, 700.0f},
                { 100.1f, 200.0f, 300.5f, 700.7f},
        };
    }

    @Test
    public void checkBurgerPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(bun_price);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredient_price);
        Mockito.when(ingredient2.getPrice()).thenReturn(ingredient2_price);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        assertThat("Неверная стоимость ингредиента!", burger.getPrice(), is(burger_price));
    }
}
