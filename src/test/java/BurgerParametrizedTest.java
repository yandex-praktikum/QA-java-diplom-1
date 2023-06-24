import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    private Burger burger;

    private float totalPrice;

    public BurgerParametrizedTest(float bunPrice, List<Float> ingredientPrices, float totalPrice) {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        Burger burger = new Burger();
        burger.setBuns(bun);

        for (float ingredientPrice : ingredientPrices) {
            Ingredient ingredient = Mockito.mock(Ingredient.class);
            Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

            burger.addIngredient(ingredient);
        }

        this.burger = burger;
        this.totalPrice = totalPrice;
    }

    @Parameterized.Parameters(name = "{index} : price = {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
            {60.0f, List.of(45.0f, 35.0f), 200.0f},
            {0.0f, List.of(45.0f, 35.0f), 80.0f},
            {60.0f, List.of(35.0f), 155.0f},
            {60.0f, List.of(45.0f), 165.0f},
            {60.0f, List.of(), 120.0f},
            {0.0f, List.of(45.0f), 45.0f},
            {0.0f, List.of(35.0f), 35.0f},
            {0.0f, List.of(), 0.0f},
        };
    }

    @Test
    public void getPrice() {
        assertEquals(totalPrice, burger.getPrice(), 0.0f);
    }
}