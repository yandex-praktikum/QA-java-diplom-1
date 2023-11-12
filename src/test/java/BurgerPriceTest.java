import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class BurgerPriceTest {
    private final int priceBun;
    private final int priceIngredient;
    private Burger burger;
    @Mock
    private Bun bun;

    public BurgerPriceTest(int priceBun, int priceIngredient) {
        this.priceBun = priceBun;
        this.priceIngredient = priceIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {5, 6},
                {15, 33},
                {8, 43}
        };
    }

    @Before
    public void setUp() {
        initMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.соус, "вишня", priceIngredient);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getPrice() {
        Mockito
                .when(burger.bun.getPrice())
                .thenReturn(priceBun);
        int price = burger.bun.getPrice() * 2;

        for (Ingredient ingredient : burger.ingredients) {
            price += ingredient.getPrice();
        }

        assertEquals("Проверим цену", price, burger.getPrice(), 0);
    }
}