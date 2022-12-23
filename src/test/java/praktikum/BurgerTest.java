package praktikum;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {

    private final Bun bun = mock(Bun.class);
    private final Burger burger = new Burger();

    private final float bunPrice;
    private final List<Float> ingredientsPrice;
    private final float sum;

    public BurgerTest(float bunPrice, List<Float> ingredientsPrice, float sum) {
        this.bunPrice = bunPrice;
        this.ingredientsPrice = ingredientsPrice;
        this.sum = sum;
    }

    @Parameterized.Parameters(name = "Цена булки: {0}, цены ингредиентов: {1}")
    public static Object[][] pricesParameters() {
        return new Object[][] {
                {10.0f, List.of(100.0f), 120.0f},
                {100.0f, List.of(100.0f, 50.0f, 15.0f), 365.0f},
                {250.0f, List.of(1000.0f, 10.1f, 15.5f), 1525.6f},
                {50.0f, List.of(1.0f, 12.0f, 22.0f, 23.0f), 158.0f},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger.setBuns(bun);
    }

    @Test
    public void burgerGetPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);

        for (int i = 0; i < ingredientsPrice.size(); i++) {
            burger.ingredients.add(mock(Ingredient.class));
            Mockito.when(burger.ingredients.get(i).getPrice()).thenReturn(ingredientsPrice.get(i));
        }

        assertEquals(sum, burger.getPrice(), 0.0f);
    }

    @Test
    public void burgerGetReceiptTest() {

        String bunName = "bunName";
        String ingredientName = "ingredientName";

        when(bun.getPrice()).thenReturn(bunPrice);
        when(bun.getName()).thenReturn(bunName);

        IngredientType ingredientType = mock(IngredientType.class);

        for (int i = 0; i < ingredientsPrice.size(); i++) {
            burger.ingredients.add(mock(Ingredient.class));
            when(burger.ingredients.get(i).getType()).thenReturn(ingredientType);
            when(burger.ingredients.get(i).getName()).thenReturn(ingredientName);
            when(burger.ingredients.get(i).getPrice()).thenReturn(ingredientsPrice.get(i));
        }

        String receipt = burger.getReceipt();

        int countBuns = StringUtils.countMatches(receipt, bunName);
        int countIngredients = StringUtils.countMatches(receipt,
                ingredientType.toString().toLowerCase() + " " + ingredientName);

        assertEquals(2, countBuns);
        assertEquals(ingredientsPrice.size(), countIngredients);
        assertTrue(receipt.contains(String.format("%f", sum)));
    }
}